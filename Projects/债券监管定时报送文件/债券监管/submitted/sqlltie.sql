CREATE TABLE [job_log_tab](
  [id] INTEGER PRIMARY KEY AUTOINCREMENT, 
  [interface_code] VARCHAR(20), 
  [version_number] INTEGER(2), 
  [interface_date] VARCHAR(20),
  [total_number] INTEGER(10));