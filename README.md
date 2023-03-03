# Agora Energiewende Agorameter

## Anleitung für die Ausführung
- Zum Persistieren der Daten wird eine Verbindung zu einer Datenbank benötigt. Für die Verbindung zu einer lokalen Datenbank habe ich XAMPP verwendet.
- Die lokale Datenbank muss die Tabelle mit dem Namen "agora_energiewende" und die dazugehörigen Tabellenstrukturen beinhalten. Im Projekt befindet sich eine
.sql Datei, die importiert werden kann, um die notwendige Datenbankstruktur herzustellen.
- Anschließend kann die Controller-Klasse ausgeführt werden, um das Programm zu starten.
- Der Zeitrauum aus der die Daten abgegriffen werden sollen, muss im vorgegebenen Format eingegeben werden. Das vorgegebene Format 
wird in der GUI angezeigt. Validierung des Formats ist WIP.
- Fehler werden aktuell nur in der Konsole angezeigt.
