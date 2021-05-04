function changeColor() {
    let value = document.getElementById("colorChanger").value;
    console.log(value)
    let headerColor = document.getElementById("userHeader");
    let data = 'linear-gradient(0.25turn, ' + value + ', palevioletred)';
    console.log(data);
    headerColor.style.backgroundColor = data;

}