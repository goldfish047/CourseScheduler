document.addEventListener("DOMContentLoaded", function () {
    fetch("course1.json")
        .then(response => response.json())
        .then(data => generateTable(data))
        .catch(error => console.log(error));
});

function generateTable(data) {
    const scheduleBody = document.getElementById("scheduleBody");
    const mondayCheckbox = document.getElementById("mondayCheckbox");
    const tuesdayCheckbox = document.getElementById("tuesdayCheckbox");
    const wednesdayCheckbox = document.getElementById("wednesdayCheckbox");
    const thursdayCheckbox = document.getElementById("thursdayCheckbox");
    const fridayCheckbox = document.getElementById("fridayCheckbox");
    const tbaCheckbox = document.getElementById("tbaCheckbox");

    const mondayColumn = document.querySelectorAll(".monday");
    const tuesdayColumn = document.querySelectorAll(".tuesday");
    const wednesdayColumn = document.querySelectorAll(".wednesday");
    const thursdayColumn = document.querySelectorAll(".thursday");
    const fridayColumn = document.querySelectorAll(".friday");
    const tbaColumn = document.querySelectorAll(".tba");

    function toggleColumnVisibility(checkbox, column) {
        checkbox.addEventListener("change", function () {
            column.forEach(cell => {
                cell.style.display = checkbox.checked ? "" : "none";
            });

            const columnIndex = Array.from(scheduleTable.rows[0].cells).indexOf(column[0]);

            Array.from(scheduleTable.rows).forEach(row => {
                const cell = row.cells[columnIndex];
                cell.style.display = checkbox.checked ? "" : "none";
            });
        });
    }

    toggleColumnVisibility(mondayCheckbox, mondayColumn);
    toggleColumnVisibility(tuesdayCheckbox, tuesdayColumn);
    toggleColumnVisibility(wednesdayCheckbox, wednesdayColumn);
    toggleColumnVisibility(thursdayCheckbox, thursdayColumn);
    toggleColumnVisibility(fridayCheckbox, fridayColumn);
    toggleColumnVisibility(tbaCheckbox, tbaColumn);

    data.forEach(entry => {
        const row = document.createElement("tr");
        const nameCell = document.createElement("td");
        nameCell.textContent = entry.Name;
        row.appendChild(nameCell);

        const days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];
        days.forEach(day => {
            const cell = document.createElement("td");
            const time = entry[`AM -- ${day}`] || entry[`PM -- ${day}`] || entry[`EVE -- ${day}`] || "";
            const displayTime = time.replace(/(?:\s|^)\S*day(?:\s|$)/g, "");
            cell.textContent = displayTime;
            row.appendChild(cell);
        });

        const tbaCell = document.createElement("td");
        tbaCell.textContent = entry.TBA || "";
        row.appendChild(tbaCell);

        scheduleBody.appendChild(row);
    });
}