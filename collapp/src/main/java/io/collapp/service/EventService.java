

package io.collapp.service;

import io.collapp.model.CardLabel;
import io.collapp.model.CardLabelValue;
import io.collapp.model.Event;
import io.collapp.model.LabelListValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class EventService {

	private final EventRepository eventRepository;
	private final CardLabelRepository labelRepository;

	public EventService(EventRepository eventRepository, CardLabelRepository labelRepository) {
		this.eventRepository = eventRepository;
		this.labelRepository = labelRepository;
	}

	@Transactional(readOnly = false)
	public Event insertLabelEvent(String labelName, int cardId, int userId, Event.EventType event,
			CardLabelValue.LabelValue value, CardLabel.LabelType labelType, Date time) {

		if (labelType == CardLabel.LabelType.LIST) {
			labelType = CardLabel.LabelType.STRING;
			LabelListValue llv = labelRepository.findListValueById(value.getValueList());
			value = new CardLabelValue.LabelValue(llv.getValue(), value.getValueTimestamp(), value.getValueInt(),
					value.getValueCard(), value.getValueUser(), null);
		}

		return eventRepository.insertLabelEvent(labelName, cardId, userId, event, value, labelType, time);
	}
}
