
fetch('timetable.json')
    .then(response => response.json())
    .then(data => {
        const timetable = document.getElementById('timetable');
        const headerRow = document.getElementById('header-row');
        const timetableBody = document.getElementById('timetable-body');
        const searchInput = document.getElementById('search-input');
        const filterButton = document.getElementById('filter-button');
        const filterCheckbox = document.getElementById('filter-checkbox');
        const filterCheckbox2 = document.getElementById('filter-checkbox2');
        const filterCheckbox3 = document.getElementById('filter-checkbox3');
        const filterCheckbox4 = document.getElementById('filter-checkbox4');
        const filterCheckbox5 = document.getElementById('filter-checkbox5');
        const filterCheckbox6 = document.getElementById('filter-checkbox6');
        const filterCheckbox7 = document.getElementById('filter-checkbox7');
        const filterCheckbox8 = document.getElementById('filter-checkbox8');
        const filterCheckbox9 = document.getElementById('filter-checkbox9');
        const filterCheckbox10 = document.getElementById('filter-checkbox10');
        const filterCheckbox11 = document.getElementById('filter-checkbox11');
        const filterCheckbox12 = document.getElementById('filter-checkbox12');
        const filterCheckbox13 = document.getElementById('filter-checkbox13');
        const filterCheckbox14 = document.getElementById('filter-checkbox14');



        // Manually define the order of time slots
        const timeSlotOrder = [
            "AM -- Monday",
            "PM -- Monday",
            "EVE -- Monday",
            "AM -- Tuesday",
            "PM -- Tuesday",
            "EVE -- Tuesday",
            "AM -- Wednesday",
            "PM -- Wednesday",
            "EVE -- Wednesday",
            "AM -- Thursday",
            "PM -- Thursday",
            "EVE -- Thursday",
            "AM -- Friday",
            "PM -- Friday"
        ];

        // Generate header row
        timeSlotOrder.forEach(timeSlot => {
            const th = document.createElement('th');
            th.textContent = timeSlot;
            headerRow.appendChild(th);
        });

        // Populate timetable body
        const populateTimetable = (data) => {
            timetableBody.innerHTML = '';

            data.forEach(entry => {
                const row = document.createElement('tr');

                // Iterate over time slots
                timeSlotOrder.forEach(timeSlot => {
                    const td = document.createElement('td');
                    td.textContent = entry[timeSlot] === 'Checked' ? entry['Name'] : '';

                    // Apply classes to cells based on entry status
                    if (entry[timeSlot] !== 'Checked') {
                        td.classList.add('green-cell');
                    }
                    if (entry[timeSlot] == 'Checked') {
                        td.classList.add('red-cell');
                    }

                    row.appendChild(td);
                });

                timetableBody.appendChild(row);
            });
        };

        const filterTimetable = () => {
            const columnHeaders = headerRow.querySelectorAll('th');
            const isCheckboxChecked = filterCheckbox.checked;
            const isCheckbox2Checked = filterCheckbox2.checked;
            const isCheckbox3Checked = filterCheckbox3.checked;

            const isCheckbox4Checked = filterCheckbox4.checked;
            const isCheckbox5Checked = filterCheckbox5.checked;
            const isCheckbox6Checked = filterCheckbox6.checked;

            const isCheckbox7Checked = filterCheckbox7.checked;
            const isCheckbox8Checked = filterCheckbox8.checked;
            const isCheckbox9Checked = filterCheckbox9.checked;
            const isCheckbox10Checked = filterCheckbox10.checked;
            const isCheckbox11Checked = filterCheckbox11.checked;
            const isCheckbox12Checked = filterCheckbox12.checked;
            const isCheckbox13Checked = filterCheckbox13.checked;
            const isCheckbox14Checked = filterCheckbox14.checked;

            columnHeaders.forEach(header => {
                const timeSlot = header.textContent;
                if (
                    (timeSlot === "AM -- Monday" && isCheckboxChecked) ||
                    (timeSlot === "PM -- Monday" && isCheckbox2Checked) ||
                    (timeSlot === "EVE -- Monday" && isCheckbox3Checked) ||
                    (timeSlot === "AM -- Tuesday" && isCheckbox4Checked) ||
                    (timeSlot === "PM -- Tuesday" && isCheckbox5Checked) ||
                    (timeSlot === "EVE -- Tuesday" && isCheckbox6Checked) ||
                    (timeSlot === "AM -- Wednesday" && isCheckbox7Checked) ||
                    (timeSlot === "PM -- Wednesday" && isCheckbox8Checked) ||
                    (timeSlot === "EVE -- Wednesday" && isCheckbox9Checked) ||
                    (timeSlot === "AM -- Thursday" && isCheckbox10Checked) ||
                    (timeSlot === "PM -- Thursday" && isCheckbox11Checked) ||
                    (timeSlot === "EVE -- Thursday" && isCheckbox12Checked) ||
                    (timeSlot === "AM -- Friday" && isCheckbox13Checked) ||
                    (timeSlot === "PM -- Friday" && isCheckbox14Checked)
                ) {
                    header.style.display = 'table-cell';
                    timetableBody.querySelectorAll(`td:nth-child(${header.cellIndex + 1})`).forEach(td => {
                        td.style.display = 'table-cell';
                    });
                } else {
                    header.style.display = (isCheckboxChecked || isCheckbox2Checked || isCheckbox3Checked || isCheckbox4Checked || isCheckbox5Checked || isCheckbox6Checked || isCheckbox7Checked || isCheckbox8Checked || isCheckbox9Checked || isCheckbox10Checked || isCheckbox11Checked || isCheckbox12Checked || isCheckbox13Checked || isCheckbox14Checked) ? 'none' : 'table-cell';
                    timetableBody.querySelectorAll(`td:nth-child(${header.cellIndex + 1})`).forEach(td => {
                        td.style.display = (isCheckboxChecked || isCheckbox2Checked || isCheckbox3Checked || isCheckbox4Checked || isCheckbox5Checked || isCheckbox6Checked || isCheckbox7Checked || isCheckbox8Checked || isCheckbox9Checked || isCheckbox10Checked || isCheckbox11Checked || isCheckbox12Checked || isCheckbox13Checked || isCheckbox14Checked) ? 'none' : 'table-cell';
                    });
                }
            });
        };

        filterCheckbox.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox2.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox3.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox4.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox5.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox6.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox7.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox8.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox9.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox10.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox11.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox12.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox13.addEventListener('change', () => {
            filterTimetable();
        });

        filterCheckbox14.addEventListener('change', () => {
            filterTimetable();
        });


        const searchInstructors = () => {
            const searchValue = searchInput.value.trim().toLowerCase();
            let filteredData = data;
            if (searchValue) {
                filteredData = filteredData.filter(entry => entry['Name'] && entry['Name'].toLowerCase().includes(searchValue));
            }

            populateTimetable(filteredData);

            // Filter columns based on checkbox status
            filterTimetable();
        };

        // Event listener for input change in search input
        searchInput.addEventListener('input', searchInstructors);



        // Initial population of timetable
        populateTimetable(data);
    })
    .catch(error => console.error(error));