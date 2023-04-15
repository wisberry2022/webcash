// @왕인서
// DOM 요소를 관리할 수 있는 클래스
// 자식 요소를 id로 잡을 수 있을 경우, 부모 요소를 setter로 주입받아, 하위 요소들을 한꺼번에 관리할 수 있도록 도와줍니다

class FindElementModule {

  #targetElement;

  constructor() {}

  setElement(idName) {
    const eleObj = {};
    
    $(idName).children().map((_, item) => {
      eleObj[$(item).attr('id')] = $(item);
    })

    this.#targetElement = eleObj;
  }

  getTargetElement(elementName) {
    if(elementName) {
      return this.#targetElement[elementName];
    }
    return this.#targetElement;
  }

  getChildrenIds() {
    return Object.keys(this.#targetElement);
  }

}

export {FindElementModule}