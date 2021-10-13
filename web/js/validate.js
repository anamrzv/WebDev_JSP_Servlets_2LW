let y;

document.getElementById("function-btn").addEventListener("click", validate);

function validate() {
    if (!validateY());
}

function validateY() {
    let yText = document.getElementById("yField");
    y = yText.value.trim();
    if (/^-?\d+\.?\d*$/.test(y)) {
        if (y >= 3 || y <= -5) {
            yText.setCustomValidity("Число вне допустимого диапазона");
            return false;
        } else {
            yText.setCustomValidity("")
            return true;
        }
    } else {
        yText.setCustomValidity("Некорректный вид числа");
        return false;
    }
}

function controlCheckbox(element) {
    let checkboxes = document.getElementsByName(element.name);
    for (let i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = false;
    }
    element.checked = true;
}