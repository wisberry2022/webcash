document.addEventListener('DOMContentLoaded', () => {
  function createElement(parentElem, hopeElem, contents) {
    const newElem = document.createElement(hopeElem);
    newElem.innerText = contents;
    parentElem.appendChild(newElem);
  }

  const Parent = document.querySelector(".btnBox");
  const BTN = document.querySelector(".tBtn");

  BTN.addEventListener("click", (e) => {
    const prm = new Promise((resolve, reject) => {
      setTimeout(() => {
        try {
          createElement(Parent, 'div', 'HELLO');
          resolve(1);
        }
        catch (error) {
          console.log(error)
          resolve(0);
        }
      }, 3500)
    })
    prm.then((res) => console.log(res));
  });

});