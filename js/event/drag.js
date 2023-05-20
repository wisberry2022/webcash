// 스티커 만드는 함수

const createPost = (event, className) => {
  const newElem = document.createElement("div");
  newElem.classList.add(className);
  newElem.style.left = `${event.offsetX}px`;
  newElem.style.top = `${event.offsetY}px`;
  return newElem;
}

window.addEventListener("DOMContentLoaded", () => {

  const postArr = [];
  const postArea = document.querySelector(".postArea");
  const postSet = document.querySelector('#postNumber');

  let maxPost = postSet.value;

  postSet.addEventListener('change', e => {
    maxPost = e.currentTarget.value;
    if (maxPost < postArr.length) {
      for (i = 0; i < postArr.length - maxPost; i++) {
        postArr.shift().remove();
      }
    }
  });

  postArea.addEventListener('click', e => {
    const newElem = createPost(e, 'post');

    if (postArr.length >= maxPost) {
      postArr.shift().remove();
    }

    postArr.push(newElem);


    e.currentTarget.appendChild(newElem);

  })

});