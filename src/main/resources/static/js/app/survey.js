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

        localStorage.setItem("s1", "눈을 들어 본인의 노트북을 봅니다. 어떤 모양이 보이나요?");
        localStorage.setItem("s2", "안녕하세요! 페어를 만났습니다, 누구의 컴퓨터를 사용 할것 입니까?");
        localStorage.setItem("s3", "페어 프로그래밍을 시작합니다. 두근 두근.. 앗! 그전에 쉬는 시간은 어떻게 하는게 좋을까요?");
        localStorage.setItem("s4", "즐거운 페어 프로그래밍! 순서는 어떻게 돌아가는게 좋을까요?");
        localStorage.setItem("s5", "째깍째깍.. 저녁 6시가 되었습니다. 아직 할 건 남아있는데.. 페어에게 건네는 당신의 말은?");
        localStorage.setItem("s6", "테스트 메소드 명");
        localStorage.setItem("s7", "git 컨벤션");
        localStorage.setItem("s8", "이후에 만날 나의 크루에게 처음으로 하고 싶은 말");

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
    changeQuestion: key => document.getElementById("question").innerHTML = localStorage.getItem(key),
    toStage: (key, changeQuestion, _this) => {
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
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "MacGyver");
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
                });
                break;
            }
            case 7 : {
                document.getElementById("left").innerHTML = "우선 돌아가는 코드를 만들거에요!";
                document.getElementById("right").innerHTML = "모든 가능성을 고려한 코드를 작성하는 편이에요!";
                $('#left').on('click', () => {
                    localStorage.setItem("type", "MacGyver");
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "The Architect");
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
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
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
                });
                break;
            }
            case 9 : {
                document.getElementById("left").innerHTML = "열정!";
                document.getElementById("right").innerHTML = "재능!";
                $('#left').on('click', () => {
                    localStorage.setItem("type", "Code Guardian");
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
                });
                $('#right').on('click', () => {
                    localStorage.setItem("type", "Ninja");
                    _this.removeLeftRightButtons();
                    _this.toStyle("s1", _this);
                });
                break;
            }

        }
    },
    removeLeftRightButtons: () => {
        $('#left').remove();
        $('#right').remove();
    },
    toStyle: (key, _this) => {
        _this.changeQuestion(key);
        _this.createStyleOptionsIn(key);
        let nextKey = _this.getNextOf(key);
        $('.styleOption').on('click', () => {
            localStorage.setItem(key, $(this).innerText);
            _this.deleteStyleOptions();
            _this.toStyle(nextKey, _this);
        })
    },

    createStyleOptionsIn: key => {
        switch (key) {
            case "s1" : {
                const options = ["사과", "창문", "펭귄"];
                options.forEach(option => {
                    var button = document.createElement('button');
                    var text = document.createTextNode(option);
                    button.appendChild(text);
                    button.className = 'styleOption';
                    document.body.appendChild(button);
                })
                break;
            }
            case "s2" : {
                const options = ["내 컴퓨터", "페어의 컴퓨터", "아무거나", "번갈아가면서"];
                options.forEach(option => {
                    var button = document.createElement('button');
                    var text = document.createTextNode(option);
                    button.appendChild(text);
                    button.className = 'styleOption';
                    document.body.appendChild(button);
                })
                break;
            }
            case "s3" : {
                const options = ["저는 진짜 힘들때까진 계속 코딩 하는 편이에요", "저는 일정 시간마다 쉬어야 합니다.", "저는 뭐.. 상관 없습니다."];
                options.forEach(option => {
                    var button = document.createElement('button');
                    var text = document.createTextNode(option);
                    button.appendChild(text);
                    button.className = 'styleOption';
                    document.body.appendChild(button);
                })
                break;
            }
            case "s4" : {
                const options = ["시간을 정해서 돌아간다.", "기능을 정해서 돌아간다."];
                options.forEach(option => {
                    var button = document.createElement('button');
                    var text = document.createTextNode(option);
                    button.appendChild(text);
                    button.className = 'styleOption';
                    document.body.appendChild(button);
                })
                break;
            }
            case "s5" : {
                const options = ["밥먹고 더할까요?", "내일 마무리 해보죠.", "상대방의 말을 기다린다."];
                options.forEach(option => {
                    var button = document.createElement('button');
                    var text = document.createTextNode(option);
                    button.appendChild(text);
                    button.className = 'styleOption';
                    document.body.appendChild(button);
                })
                break;
            }
        }
    },
    getNextOf: key => {
        switch (key) {
            case "s1" :
                return "s2";
            case "s2" :
                return "s3";
            case "s3" :
                return "s4";
            case "s4" :
                return "s5";
            case "s5" :
                return "s6";
            case "s6" :
                return "s7";
            case "s7" :
                return "s8";
        }
    },
    deleteStyleOptions: () => {
        $('.styleOption').remove();
    }
}

main.init();