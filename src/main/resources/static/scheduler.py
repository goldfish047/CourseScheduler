from numpy import nan
import pandas as pd
# Replace 'path/to/your/file.xlsx' with the actual path to your Excel file
filePathSurvey = './Summer_2023_Timetable_Survey.xlsx';
filePathSchedule = './Summer_2023_Teaching_Schedule.xlsx';


# Load all sheets from the Excel file into a dictionary of DataFrames
all_dataframes = pd.read_excel(filePathSurvey, sheet_name=None)
all_dataframesSchedule = pd.read_excel(filePathSchedule, sheet_name=None)


# If you want to load a specific sheet, you can use the following instead:
# dataframe = pd.read_excel(file_path, sheet_name='Sheet1')

# Print the data in each DataFrame

df1 = []

for sheet_name, dataframe in all_dataframes.items():
    # print(f"Data in sheet '{sheet_name}':")
    df1 = dataframe
new_column_names = {
    'EVE -- Monday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Monday EVE',
    'PM -- Monday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Monday PM',
    'AM -- Monday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Monday AM',
    'EVE -- Tuesday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Tuesday EVE',
    'PM -- Tuesday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Tuesday PM',
    'AM -- Tuesday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Tuesday AM',
    'EVE -- Wednesday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Wednesday EVE',
    'PM -- Wednesday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Wednesday PM',
    'AM -- Wednesday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Wednesday AM',
    'EVE -- Thursday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Thursday EVE',
    'PM -- Thursday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Thursday PM',
    'AM -- Thursday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Thursday AM',
    'PM -- Friday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Friday PM',
    'AM -- Friday -- Please indicate which of our teaching blocks you are <b><u><font style="color:blue;">UNAVAILABLE</font></u></b> to be scheduled.': 'Friday AM',
    'Please let us know how you prefer to schedule multiple classes, and we will try to accommodate:': 'Schedule availabilty'
}

df1.head()

# AM - 8:30 to 12:30
# PM - 1:30 to 5:30
# EVE - 5:45 to 10:45
df1.rename(columns=new_column_names, inplace=True)
df_filtered_1 = df1[['1. Please share your contact information: - First',
'Monday EVE',
'Monday PM',
'Monday AM',
'Tuesday EVE',
'Tuesday PM',
'Tuesday AM',
'Wednesday EVE',
'Wednesday PM',
'Wednesday AM',
'Thursday EVE',
'Thursday PM',
'Thursday AM',
'Friday PM',
'Friday AM',
'Schedule availabilty',
     ]]



# df_filtered_1.head()
i = 0
for sheet_name, dataframe in all_dataframesSchedule.items():
    # print(f"Data in sheet '{sheet_name}':")
    if i == 0:
      df2 = dataframe
    i = i + 1


# Select columns with keywords "Course" or "Section"
df2.head()
selected_columns = df2.filter(like='Course').columns | df2.filter(like='Section').columns | df2.filter(like='Program').columns | df2.filter(like='Time').columns | df2.filter(like='Subject to Enrolment').columns

# # # Create a new DataFrame with the selected columns


df2 = df2[selected_columns]

df2_1 = df2['Course 1']
df2_1 = df2['Section /01']

df_arr = []

for i in range(1, 8):
  #print(df2.columns)
  df_new = df2[[f"Course {i}", f"Section /0{i}", f"Time {i}", f"Subject to Enrolment {i}","Program"]]
  df_arr.append(df_new)

for i in range(0, len(df_arr)):
  # print("BEFORE >>>>" , df_arr[i].columns)
  new_column_names = {
    f"Course {i+1}": 'Course',
    f"Section /0{i+1}": 'Section',
    f"Time {i+1}": "Time",
    f"Subject to Enrolment {i+1}": "Subject to Enrolment"
  }

  df_arr[i].rename(columns=new_column_names, inplace=True)
  #print("HELLO >>>>" , df_arr[i].columns)


# for i in range(0, len(df_arr)):
#   df_arr[i].to_csv(f"op-{i}.csv", index=False)

# Perform a union of DataFrames in the array
union_df = pd.concat(df_arr, ignore_index=True)

# Print the resulting DataFrame after union
# print("hi")
# print(union_df.head())

# Remove the pattern and update the 'Section' column
union_df['Section'] = union_df['Section'].str.replace(r'\/0(\d+)', r'\1')


# print(type(union_df))

# for i in range(1, 8):
#   print("HELLO >>", f'\0{i}', f"{i}")
#   union_df['Section'] = union_df['Section'][1]


union_df.head()

btbSchedules = []
instructorIndexForBtbSchedule = -1
#for column in union_df[['Section','Course','Time']]:
for index, row in union_df.iterrows():
    schedules = str(row['Time']).split("&")
    # course = row['Course']


    for scheduleIndex, schedule in enumerate(schedules):
      scheduleTime = schedule.strip()
      isAssigned = False
      if len(btbSchedules) != 0:
        for btbSchedule in btbSchedules:
          if btbSchedules == scheduleTime:
            instructor = df_filtered_1[instructorIndexForBtbSchedule, '1. Please share your contact information: - First']
            if scheduleIndex == 0:
              union_df.at[index, 'Instructor Num'] = instructor
              union_df.at[index, 'Time'] = schedule

            else:
              new_row = {'Course': union_df.at[index, 'Course'], 'Section': union_df.at[index, 'Section'], 'Subject to Enrolment': union_df.at[index, 'Subject to Enrolment'], 'Program': union_df.at[index, 'Program'], 'Instructor Num': instructor}
 
              # Use the loc method to add the new row to the DataFrame
              union_df.loc[len(union_df)] = new_row  
            # Update time column with schedules[0]
            # add new row with course name, time with schedules[1..], subject, program and instrictor
            currentDay = scheduleTime.split(" ")[0]
            df_filtered_1.at[instructorIndex, currentDay + " EVE"] = "Unchecked"
            df_filtered_1.at[instructorIndex, currentDay + " PM"] = "Unchecked"
            df_filtered_1.at[instructorIndex, currentDay + " AM"] = "Unchecked"
            isAssigned = True
            break

        if isAssigned == True: 
           instructorIndexForBtbSchedule = -1
           btbSchedules = []
           continue

      if scheduleTime != 'nan':
         for instructorIndex, instructorRow in df_filtered_1.iterrows():
            if df_filtered_1.loc[instructorIndex, scheduleTime] == "Checked":
              print(scheduleTime)
              print(str(row['Course']))
              print(instructorRow['1. Please share your contact information: - First'])

              instructor = instructorRow['1. Please share your contact information: - First']
              if scheduleIndex == 0:
                union_df.at[index, 'Instructor Num'] = instructor
                union_df.at[index, 'Time'] = schedule

              else:
                new_row = {'Course': union_df.at[index, 'Course'], 'Section': union_df.at[index, 'Section'], 'Time': scheduleTime, 'Subject to Enrolment': union_df.at[index, 'Subject to Enrolment'], 'Program': union_df.at[index, 'Program'], 'Instructor Num': instructor}
                union_df.loc[len(union_df)] = new_row  

              # union_df.at[index, 'Instructor Num'] = instructorRow['1. Please share your contact information: - First']
              if df_filtered_1.loc[instructorIndex, 'Schedule availabilty'] == "Only one class per day":
                currentDay = scheduleTime.split(" ")[0]
                df_filtered_1.at[instructorIndex, currentDay + " EVE"] = "Unchecked"
                df_filtered_1.at[instructorIndex, currentDay + " PM"] = "Unchecked"
                df_filtered_1.at[instructorIndex, currentDay + " AM"] = "Unchecked"
                
              elif df_filtered_1.loc[instructorIndex, 'Schedule availabilty'] == "Back-to-back scheduled classes (two in a day)":
                df_filtered_1.at[instructorIndex, scheduleTime] = "Unchecked"
                instructorIndexForBtbSchedule = instructorIndex
                for columnIndex, column_header in enumerate(df_filtered_1.columns):
                  if column_header == scheduleTime:
                    if "AM" in scheduleTime:
                      btbSchedules.append(df_filtered_1.columns[columnIndex-1])
                    elif "PM" in scheduleTime and "Friday" in scheduleTime == False:
                      btbSchedules.append(df_filtered_1.columns[columnIndex+1])
                      btbSchedules.append(df_filtered_1.columns[columnIndex-1])
                    elif "Friday" in scheduleTime:
                        btbSchedules.append(df_filtered_1.columns[columnIndex+1])
                    elif "EVE" in scheduleTime:
                      btbSchedules.append(df_filtered_1.columns[columnIndex+1])

              else: 
                df_filtered_1.at[instructorIndex, scheduleTime] = "Unchecked"
              break

    
    
  
    



# Export the DataFrame to a CSV file
csv_file_path = 'output.csv'  # Replace 'output.csv' with the desired file name and path
# Drop rows with any empty values
# selected_columns = ['Course', 'Section', 'Program']
df_cleaned = union_df
df_cleaned['Subject to Enrolment'] = df_cleaned['Subject to Enrolment'].str.replace('- Subject to Enrolment', 'yes')
df_cleaned.to_csv(csv_file_path, index=False)



df_cleaned.head()

# # Convert the DataFrame to JSON format
json_data = union_df.to_json()

# Print the JSON data
print(json_data)


