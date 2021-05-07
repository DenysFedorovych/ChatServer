

function changeColor() {
    let headerColor = document.getElementById("userHeader");
    let value = document.getElementById("colorChanger").value;
    let data = 'linear-gradient(0.25turn, ' + value + ', palevioletred)';
    headerColor.style.backgroundColor = data;
    console.log(value)
    console.log(data);


}