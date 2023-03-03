# Agora Energiewende Agorameter

## Anleitung für die Ausführung
- Laden Sie bitte zunächst das Projekt herunter.
- Zum Persistieren der Daten wird eine Verbindung zu einer Datenbank benötigt. Um die lokale Datenbank verfügbar zu machen, muss XAMPP verwendet werden.
- Die lokale Datenbank muss die Tabelle mit dem Namen "agora_energiewende" und die dazugehörigen Tabellenstrukturen beinhalten. Im Projekt befindet sich eine
.sql Datei, die importiert werden muss, um die notwendige Datenbankstruktur herzustellen.
- Anschließend kann die Controller-Klasse ausgeführt werden, um das Programm zu starten.
- Der Zeitraum aus der die Daten abgegriffen werden sollen, muss im vorgegebenen Format eingegeben werden. Das vorgegebene Format 
wird in der GUI angezeigt. Validierung des Formats ist noch in bearbeitung.
- Die Persistierung kann etwas dauern, wenn es abgeschlossen wurde wird leider noch kein Feedback angezeigt. Dass die Persistierung abgeschlossen wurde erkennt man daran, dass
der Button nicht mehr im gedrückten Zustand ist.
- Fehler werden aktuell nur in der Konsole angezeigt.
