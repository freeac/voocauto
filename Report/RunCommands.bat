cd Report

for /f "delims=" %%a in ('wmic OS Get localdatetime  ^| find "."') do set dt=%%a
set datestamp=%dt:~0,8%
set timestamp=%dt:~8,6%
set YYYY=%dt:~0,4%
set MM=%dt:~4,2%
set DD=%dt:~6,2%
set HH=%dt:~8,2%
set Min=%dt:~10,2%
set Sec=%dt:~12,2%

java -jar Reporthtml.jar "%cd%/VOOC_Report_Automation_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%"

java -jar CompressFile.jar 1 "C:\temp\report\VOOC_Report_Automation_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%.zip" "%cd%/VOOC_Report_Automation_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%"

java -jar MoveFile.jar "%cd%/VOOC_Report_Automation_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%" "C:\temp\report\VOOC_Report_Automation_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%"

java -jar MoveFile.jar "%cd%/..\Logs\Log.txt" "C:\temp\log\Log_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%.txt"

java -jar SendMail.jar "C:\temp\report\VOOC_Report_Automation_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%.zip" nhanvuong@vooc.vn

java -jar DeleteFile.jar 1 "C:\temp\report\Report_APi_%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%.zip"
