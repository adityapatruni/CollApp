
ALTER TABLE LA_PROJECT_MAIL_TICKET_CONFIG ADD MAIL_CONFIG_SUBJECT TEXT;
ALTER TABLE LA_PROJECT_MAIL_TICKET_CONFIG ADD MAIL_CONFIG_BODY TEXT;
ALTER TABLE LA_PROJECT_MAIL_TICKET_CONFIG DROP MAIL_CONFIG_PROPERTIES;
