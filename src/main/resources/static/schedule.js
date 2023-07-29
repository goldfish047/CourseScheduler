
fetch('Output4.json')
    .then(response => response.json())
    .then(data => {
        const timetable = document.getElementById('schedule');
        const headerRow = document.getElementById('header-row');
        const timetableBody = document.getElementById('schedule-body');

        const columnOrder = [
            "Course",
            "Section",
            "Time", 
            "Subject to Enrolment",
            "Program",
            "Instructor Num",
            "Room Number"
        ];

        //Generate header row   
        columnOrder.forEach(column => {
            const th = document.createElement('th');
            th.textContent = column; 
            headerRow.appendChild(th);
        });

        // populate timetable body 
        const populateTimetable = (data) => {
            timetableBody.innerHTML = '';

            data.forEach(entry => {
                const row = document.createElement('tr');

                
                columnOrder.forEach(columnSlot => {
                    const td = document.createElement('td');
                    td.textContent = entry[columnSlot]
                    row.appendChild(td);
                })


                timetableBody.appendChild(row);
            })


        };


        populateTimetable(data);
    })
    .catch(error => console.error(error));
