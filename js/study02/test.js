window.addEventListener('DOMContentLoaded', e => {
 const obj = {
  home: 'tokyo',
  show: function() {
    return `i live ${this.home}`;
  }
 }

 console.log(obj.show());

 const temp = {home:'busan'};

 console.log(obj.show.apply(temp));
 
 
});