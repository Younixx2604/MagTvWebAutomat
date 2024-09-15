Feature: Auto_Login_negativ
    @TestCaseKey=KAN-T33
    Scenario: Auto_Login_negativ

        Given die MagentaTV Homepage "https://web.magentatv.de/" ist geöffnet
        And man die Coockies schliesst
        And der Login Button wurde angeklickt und die Login-Seite geöffnet
        When der Benutzer die Kundennummer "test123" eingibt
        And der Benutzer auf "weiter" klickt
        Then sollte eine Fehlermeldung "Benutzername ist nicht korrekt." angezeigt werden
