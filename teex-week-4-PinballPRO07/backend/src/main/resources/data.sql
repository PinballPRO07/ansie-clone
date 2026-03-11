INSERT INTO `ansie`.`openexamquestions` (`title`, `description`, `published`, `type`) VALUES ('Toetsvraag 1', 'Wat is het antwoord op toetsvraag 1?', '1', 'open');
INSERT INTO `ansie`.`openexamquestions` (`title`, `description`, `published`, `type`) VALUES ('Toetsvraag 2', 'Wat is het antwoord op toetsvraag 2?', '1', 'open');
INSERT INTO `ansie`.`openexamquestions` (`title`, `description`, `published`, `type`) VALUES ('Toetsvraag 3', 'Wat is het antwoord op toetsvraag 3?', '0', 'open');
INSERT INTO `ansie`.`openexamquestions` (`title`, `description`, `published`, `type`) VALUES ('Toetsvraag 4', 'Wat is het antwoord op toetsvraag 4?', '0', 'open');

INSERT INTO `ansie`.`mcexamquestions` (`title`, `description`, `published`, `type`) VALUES ('MC Vraag 1', 'Wat is een DTO?', '1', 'mc');
INSERT INTO `ansie`.`mcexamquestions` (`title`, `description`, `published`, `type`) VALUES ('MC Vraag 2', 'Nog een vraag?', '1', 'mc');

INSERT INTO `ansie`.`mcexamoptions` (`mcexamquestionid`, `option`, `correct`) VALUES ('5', 'Delta Tracking Order', '0');
INSERT INTO `ansie`.`mcexamoptions` (`mcexamquestionid`, `option`, `correct`) VALUES ('5', 'Data Transfer Object', '1');
INSERT INTO `ansie`.`mcexamoptions` (`mcexamquestionid`, `option`, `correct`) VALUES ('6', 'Nee', '1');
INSERT INTO `ansie`.`mcexamoptions` (`mcexamquestionid`, `option`, `correct`) VALUES ('6', 'Ja', '0');
