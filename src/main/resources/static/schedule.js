fetch('Output4.json')
    .then(response => response.json())
    .then(data => {
        const timetable = document.getElementById('schedule');
        const timetableBody = document.getElementById('schedule-body');

        const roomNumbers = Array.from(new Set(data.map(entry => entry["Room Number"])))
        .sort((a, b) => a - b);

        const columnOrder = [
            "Course",
            "Section",
            "Time", 
            "Instructor Num",
            "Room Number"
        ];

        const dayMap = {
            "Monday AM": 0,
            "Monday PM": 1,
            "Monday EVE": 2,
            "Tuesday AM": 3,
            "Tuesday PM": 4,
            "Tuesday EVE": 5,
            "Wednesday AM": 6,
            "Wednesday PM": 7,
            "Wednesday EVE": 8,
            "Thursday AM": 9,
            "Thursday PM": 10,
            "Thursday EVE": 11,
            "Friday AM": 12,
            "Friday PM": 13,
            "Friday EVE": 14,
          };

        const sortedTimes = Array.from(new Set(data.map(entry => entry["Time"])))
          .sort((a, b) => dayMap[a] - dayMap[b]);

        const populateTimetable = (data) => {
            timetableBody.innerHTML = '';
      
            const topRow = document.createElement('tr'); 
            const titleCell = document.createElement('th');
            titleCell.textContent = "Schedule"; 
            topRow.appendChild(titleCell);

            roomNumbers.forEach(roomNumber => {
                const th = document.createElement('th');
                th.textContent = "Room " + roomNumber;
                topRow.appendChild(th);
            });

            timetableBody.appendChild(topRow);

            sortedTimes.forEach(time => {
                const row = document.createElement('tr');

            
                const timeCell = document.createElement('td');
                timeCell.textContent = time;
                timeCell.classList.add('time-column');
                row.appendChild(timeCell);

                roomNumbers.forEach(roomNumber => {
                    const td = document.createElement('td');
                    const entry = data.find(entry => entry["Room Number"] === roomNumber && entry["Time"] === time);

                    if (entry) {
                        td.innerHTML = `<span class="course">${entry["Course"]}</span><br>` +
                           `<span class="instructor">${entry["Instructor Num"]}</span><br>` +
                           `<span class="section">Section ${entry["Section"]}</span>`;
                    }else {
                        td.style.background = 'repeating-linear-gradient(45deg, #bebdbd, #bebdbd 10px, #9c9c9c 10px, #a2a1a1 20px)';
                      }

                    row.appendChild(td);
                });

                timetableBody.appendChild(row);
            });
        };
        
        populateTimetable(data);
    })
    .catch(error => console.error(error));