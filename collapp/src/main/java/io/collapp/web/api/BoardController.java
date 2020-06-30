
package io.collapp.web.api;

import io.collapp.model.*;
import io.collapp.model.util.ShortNameGenerator;
import io.collapp.service.*;
import io.collapp.web.api.model.Suggestion;
import io.collapp.web.api.model.TaskStatistics;
import io.collapp.web.api.model.TaskStatisticsAndHistory;
import io.collapp.web.api.model.UpdateRequest;
import io.collapp.web.helper.ExpectPermission;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class BoardController {

	private final BoardRepository boardRepository;
	private final ProjectService projectService;
	private final SearchService searchService;
	private final StatisticsService statisticsService;
	private final EventEmitter eventEmitter;


	public BoardController(BoardRepository boardRepository, ProjectService projectService, SearchService searchService,
			EventEmitter eventEmitter, StatisticsService statisticsService) {
		this.boardRepository = boardRepository;
		this.projectService = projectService;
		this.searchService = searchService;
		this.eventEmitter = eventEmitter;
		this.statisticsService = statisticsService;
	}

	@RequestMapping(value = "/api/suggest-board-short-name", method = RequestMethod.GET)
	public Suggestion suggestBoardShortName(@RequestParam("name") String name) {
		return new Suggestion(ShortNameGenerator.generateShortNameFrom(name));
	}

	@RequestMapping(value = "/api/check-board-short-name", method = RequestMethod.GET)
	public boolean checkBoardShortName(@RequestParam("name") String name) {
		return ShortNameGenerator.isShortNameValid(name) && !boardRepository.existsWithShortName(name);
	}

	@ExpectPermission(Permission.PROJECT_ADMINISTRATION)
	@RequestMapping(value = "/api/board/{shortName}", method = RequestMethod.POST)
	public Board updateBoard(@PathVariable("shortName") String shortName, @RequestBody UpdateRequest updatedBoard, User user) {
		Board board = boardRepository.findBoardByShortName(shortName);
		board = boardRepository.updateBoard(board.getId(), updatedBoard.getName(), updatedBoard.getDescription(),
				updatedBoard.isArchived());
		eventEmitter.emitUpdateBoard(shortName, user);
		return board;
	}

	@ExpectPermission(Permission.READ)
	@RequestMapping(value = "/api/board/{shortName}", method = RequestMethod.GET)
	public Board findByShortName(@PathVariable("shortName") String shortName) {
		return boardRepository.findBoardByShortName(shortName);
	}

	@ExpectPermission(Permission.READ)
	@RequestMapping(value = "/api/board/{shortName}/task-statistics", method = RequestMethod.GET)
	public TaskStatistics boardTaskStatistics(@PathVariable("shortName") String shortName, UserWithPermission user) {
		Board board = boardRepository.findBoardByShortName(shortName);

		Map<ColumnDefinition, Integer> tasks = searchService
				.findTaksByColumnDefinition(board.getProjectId(), board.getId(), false, user);

		Map<ColumnDefinition, BoardColumnDefinition> columnDefinitions = projectService
				.findMappedColumnDefinitionsByProjectId(board.getProjectId());

		return new TaskStatistics(tasks, columnDefinitions);
	}

	@ExpectPermission(Permission.READ)
	@RequestMapping(value = "/api/board/{shortName}/statistics/{fromDate}", method = RequestMethod.GET)
	public TaskStatisticsAndHistory boardStatistics(@PathVariable("shortName") String shortName,
			@PathVariable("fromDate") Date fromDate, UserWithPermission user) {
		Board board = boardRepository.findBoardByShortName(shortName);

		Map<ColumnDefinition, Integer> tasks = searchService
				.findTaksByColumnDefinition(board.getProjectId(), board.getId(), false, user);

		Map<ColumnDefinition, BoardColumnDefinition> columnDefinitions = projectService
				.findMappedColumnDefinitionsByProjectId(board.getProjectId());

		Integer activeUsers = statisticsService.getActiveUsersOnBoard(board.getId(), fromDate);

		return new TaskStatisticsAndHistory(tasks, columnDefinitions,
				statisticsService.getCardsStatusByBoard(board.getId(), fromDate),
				statisticsService.getCreatedAndClosedCardsByBoard(board.getId(), fromDate),
				activeUsers,
				statisticsService.getAverageUsersPerCardOnBoard(board.getId()),
				statisticsService.getAverageCardsPerUserOnBoard(board.getId()),
				statisticsService.getCardsByLabelOnBoard(board.getId()),
				statisticsService.getMostActiveCardByBoard(board.getId(), fromDate));
	}
}
