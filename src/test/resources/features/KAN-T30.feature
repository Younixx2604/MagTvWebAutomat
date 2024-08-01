Feature: Auto_Homepage_öffnen 
    @TestCaseKey=KAN-T30
    Scenario: Auto_Homepage_öffnen 
        
        Given der Benutzer hat einen Webbrowser geöffnet
        When der Benutzer die URL "https://web.magentatv.de/" öffnet
        Then der URL der göffnete Seite sollte "https://web.magentatv.de/" enthalten