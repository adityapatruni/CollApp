

UPDATE LA_BOARD_COLUMN SET BOARD_COLUMN_ORDER = 0 WHERE BOARD_COLUMN_NAME = 'BACKLOG' AND BOARD_COLUMN_LOCATION = 'BACKLOG';
UPDATE LA_BOARD_COLUMN SET BOARD_COLUMN_ORDER = 0 WHERE BOARD_COLUMN_NAME = 'ARCHIVE' AND BOARD_COLUMN_LOCATION = 'ARCHIVE';
UPDATE LA_BOARD_COLUMN SET BOARD_COLUMN_ORDER = 0 WHERE BOARD_COLUMN_NAME = 'TRASH' AND BOARD_COLUMN_LOCATION = 'TRASH';
