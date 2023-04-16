import { FindElementModule } from '../js/FindElementModule.js';
import { PopUpService } from './PopUpService.js';

$(function () {
  const modalSet = new FindElementModule();
  const popUpService = new PopUpService();
  modalSet.setElement('#modalSet');

  const assignBackdrop = modalSet.getTargetElement('assignBackdrop');
  const assignCloseBtn = assignBackdrop.find('.btn-close');

  // 게시판 사용자 정보 초기 설정

  $(assignBackdrop).find('.userTab').hide();

  // 게시판 사용자 정보 모달 종료

  assignCloseBtn.on('click', () => {
    assignBackdrop.find('.nav-link').eq(0).click();
  });

  const assignBackdropNav = assignBackdrop.find('.nav').children();

  // nav tab 클릭 시 렌더링 화면 다르게 하기

  assignBackdropNav.map((idx, item) => {
    $(item).on('click', (e) => {
      let onOff = $(e.target).attr('data-click-target').split("/");

      $($(onOff[0])).show();
      $($(onOff[1])).hide();

    })
  });



  assignBackdrop.find('.form-control').map((index, item) => {
    $(item).on('click', () => {
      // console.log(location.origin);
      const param = {
        "POST_CALLBACK_PAGE": `${location.origin}/popUpCallback/emp`,
        "SECR_KEY": "hello",

        "PTL_ID": "PTL_51",
        "CHNL_ID": "CHNL_1",
        "USE_INTT_ID": "UTLZ_1709060902735",
        "USER_ID": "simdemo01t",
        "POPUP_TYPE": "P",
        "MULT_SEL_YN": "Y",
        "MY_SELYN": "N",
      };

      const popUpCallback = data => {
        $('.table tbody').text(JSON.stringify(data, null, 2));
      }

      popUpService.open("https://b2bccstm-dev.appplay.co.kr/b2bc2_comm_0001_01.act", param, popUpCallback);
    })
  });
})


