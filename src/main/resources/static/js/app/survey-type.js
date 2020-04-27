var main = {
    init: function () {
        var _this = this;
        localStorage.setItem("0", "멀티태스킹에 대해 어떻게 생각하시나요?");
        localStorage.setItem("1", "예측할 수 없는 에러가 갑자기 일어난다면, 어떻게 하겠어요?");
        localStorage.setItem("2", "협업에 대해서 어떻게 생각하시나요?");
        localStorage.setItem("3", "당신은 마감기한을 지킬 수 있나요?");
        localStorage.setItem("4", "코드 퀄리티는 중요한가요?");
        localStorage.setItem("5", "체크무늬 셔츠 좋아하시나요?");
        localStorage.setItem("6", "당신이 프로젝트를 진행하며 새로운 기술을 배워야할 할 때에...");
        localStorage.setItem("7", "일하는 스타일이 어떠세요?");
        localStorage.setItem("8", "프로젝트가 끝났을 때 당신이 드는 생각은");
        localStorage.setItem("9", "프로그래밍에 있어 가장 중요한 것은 무엇인가요?");

        _this.changeQuestion("0");
        document.getElementById("left").innerHTML = "저는 여러가지 일들을 가뿐하게 처리하죠!";
        document.getElementById("right").innerHTML = "한번에 하나의 일만 할 수는 없는건가요?";

        $('#left').on('click', () => {
            _this.toStage(1, _this.changeQuestion, _this);
        });
        $('#right').on('click', () => {
            _this.toStage(2, _this.changeQuestion, _this);
        });
    },
    changeQuestion : key => document.getElementById("question").innerHTML = localStorage.getItem(key),
    toStage : (key, changeQuestion, _this) => {
        changeQuestion(key);
        switch (key) {
            case 1 : {
                document.getElementById("left").innerHTML = "포기란 없죠! 코드에 답이 있을거에요!";
                document.getElementById("right").innerHTML = "구글신을 믿습니다..! 검색, 검색, 검색!";
                $('#left').on('click', () => {
                    _this.toStage(3, _this.changeQuestion, _this);
                });
                $('#right').on('click', () => {
                    _this.toStage(4, _this.changeQuestion, _this);
                });
                break;
            }
            case 2 : {
                document.getElementById("left").innerHTML = "백지장도 맞들면 낫죠!";
                document.getElementById("right").innerHTML = "저는 외로운 한마리 늑대에요..";
                $('#left').on('click', () => {
                    _this.toStage(4, _this.changeQuestion, _this);
                });
                $('#right').on('click', () => {
                    _this.toStage(5, _this.changeQuestion, _this);
                });
                break;
            }
            case 3 : {
                document.getElementById("left").innerHTML = "시간은 상대적인거 아시죠? 그러니까 마감기한도 상대적인거에요.";
                document.getElementById("right").innerHTML = "저는 무슨 수를 써서라도 마감기한 내에 제출할거에요!";
                $('#left').on('click', () => {
                    _this.toStage(6, _this.changeQuestion, _this);
                });
                $('#right').on('click', () => {
                    _this.toStage(7, _this.changeQuestion, _this);
                });
                break;
            }
            case 4 : {
                document.getElementById("left").innerHTML = "완벽한 코드보다 완성된 코드가 중요한 거 같아요.";
                document.getElementById("right").innerHTML = "코드는 룰을 따라야하죠! 완벽한 퀄리티가 중요해요.";
                $('#left').on('click', () => {
                    _this.toStage(7, _this.changeQuestion, _this);
                });
                $('#right').on('click', () => {
                    _this.toStage(8, _this.changeQuestion, _this);
                });
                break;
            }
            case 5 : {
                document.getElementById("left").innerHTML = "자고로 체크무늬 셔츠는 유행에 뒤떨어진 적이 없죠!";
                document.getElementById("right").innerHTML = "세상에는 체크무늬 셔츠말고도 다른 옷이 있는데 말이죠..";
                $('#left').on('click', () => {
                    _this.toStage(8, _this.changeQuestion, _this);
                });
                $('#right').on('click', () => {
                    _this.toStage(9, _this.changeQuestion, _this);
                });
                break;
            }
            case 6 : {
                document.getElementById("left").innerHTML = "저는 기술에 대해서 깊게 공부하고 시작하기 전에 여러가지 것들을 시도해보는 편이에요.";
                document.getElementById("right").innerHTML = "빠르게 기초를 배우고 코드에 바로 적용하는 편이에요.";
                $('#left').on('click', () => {
                    localStorage.setItem("type", "Mad Scientist");
                    _this.saveType();
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "MacGyver");
                    _this.saveType();
                });
                break;
            }
            case 7 : {
                document.getElementById("left").innerHTML = "우선 돌아가는 코드를 만들거에요!";
                document.getElementById("right").innerHTML = "모든 가능성을 고려한 코드를 작성하는 편이에요!";
                $('#left').on('click', () => {
                    localStorage.setItem("type", "MacGyver");
                    _this.saveType();
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "The Architect");
                    _this.saveType();
                });
                break;
            }
            case 8 : {
                document.getElementById("left").innerHTML = "시간이 더 있었다면 더 잘 할 수 있었을텐데..";
                document.getElementById("right").innerHTML = "저는 다음 도전을 기다리죠!";
                $('#left').on('click', () => {
                    _this.toStage(7, _this.changeQuestion, _this);
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "Code Guardian");
                    _this.saveType();
                });
                break;
            }
            case 9 : {
                document.getElementById("left").innerHTML = "열정!";
                document.getElementById("right").innerHTML = "재능!";
                $('#left').on('click', () => {
                    localStorage.setItem("type", "Code Guardian");
                    _this.saveType();
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "Ninja");
                    _this.saveType();
                });
                break;
            }
        }
    },
    saveType : () => {
        $.ajax({
            type: 'PUT',
            url: '/api/v1/survey-type',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(localStorage.getItem("type"))
        }).done(() => {
            localStorage.clear();
            window.location.href = '/survey-style';
        }).fail(error => {
            alert(JSON.stringify(error))
        });
    }
};

main.init();

//

(function($) {

    var form = $("#signup-form");
    form.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "fade",
        labels: {
            previous : 'Previous',
            next : 'Next',
            finish : 'Submit',
            current : ''
        },
        titleTemplate : '<div class="title"><span class="title-text">#title#</span><span class="title-number">0#index#</span></div>',
        onFinished: function (event, currentIndex)
        {
            alert('Sumited');
        }
    });


})(jQuery);
