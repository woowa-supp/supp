let currentQuestionCount = 0;

let resultMap = {};

const questions = [
    "눈을 들어 본인의 노트북을 봅니다, 어떤 모양이 보이나요?",
    "안녕하세요! 페어를 만났습니다, 누구의 컴퓨터를 사용 할것 입니까?",
    "페어 프로그래밍을 시작합니다. 두근 두근.. 앗! 그전에 쉬는 시간은 어떻게 하는게 좋을까요?",
    "즐거운 페어 프로그래밍! 순서는 어떻게 돌아가는게 좋을까요?",
    "째깍째깍.. 저녁 6시가 되었습니다. 아직 할 건 남아있는데.. 페어에게 건네는 당신의 말은?",
    // "테스트 메소드 명",
    // "git 컨벤션",
    // "소개하는 말 한마디"
];

const answers = {
    0: ["사과", "창문", "펭귄"],
    1: ["내 컴퓨터", "페어의 컴퓨터", "아무거나", "번갈아가며"],
    2: ["저는 진짜 힘들때까진 계속 코딩 하는 편이에요.", "저는 일정 시간마다 쉬어야 합니다.", "저는 뭐... 상관 없습니다."],
    3: ["시간을 정해서 돌아간다.", "기능을 정해서 돌아간다.", "상관 없다."],
    4: ["밥먹고 더할까요?", "내일 마무리 해보죠.", "상대방의 말을 기다린다."],
    // 5 : [],
    // 6 : [],
    // 7 : []
};

function putAnswers() {
    $.ajax({
        type: 'PUT',
        url: '/api/v1/survey-style',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(resultMap)
    }).done(() => {
        window.location.href = '/result';
    }).fail(error => {
        alert(JSON.stringify(error))
    });
}

async function renderPage() {
    if (currentQuestionCount === 5) {
        putAnswers();
    } else {
        document.getElementById(`question`).innerHTML = questions[currentQuestionCount];

        await $(`.answerContainer`).empty();
        await answers[currentQuestionCount].forEach((answer) => {
            var answerButton = document.createElement('button');
            answerButton.className = `answer btn btn-primary`;
            var answerText = document.createTextNode(answer);
            answerButton.appendChild(answerText);
            $(`.answerContainer`).append(answerButton).append(document.createElement(`br`));
        });

        await $(`.answer`).on(`click`, function () {
            resultMap[currentQuestionCount++] = $(this).text();
            renderPage();
        });
    }
}

renderPage();
