let currentQuestionCount = 0;

let resultMap = {};

const questions = [
    "눈을 들어 본인의 노트북을 봅니다, 어떤 모양이 보이나요?",
    "안녕하세요! 페어를 만났습니다, 누구의 컴퓨터를 사용 할것 입니까?",
    "페어 프로그래밍을 시작합니다. 두근 두근.. 앗! 그전에 쉬는 시간은 어떻게 하는게 좋을까요?",
    "즐거운 페어 프로그래밍! 순서는 어떻게 돌아가는게 좋을까요?",
    "째깍째깍.. 저녁 6시가 되었습니다. 아직 할 건 남아있는데.. 페어에게 건네는 당신의 말은?",
    "테스트 메소드 명",
    "git 컨벤션",
    "소개하는 말 한마디"
];

const answers = {
    0: ["사과", "창문", "펭귄"],
    1: ["내 컴퓨터", "페어의 컴퓨터", "아무거나", "번갈아가며"],
    2: ["저는 진짜 힘들때까진 계속 코딩 하는 편이에요.", "저는 일정 시간마다 쉬어야 합니다.", "저는 뭐... 상관 없습니다."],
    3: ["시간을 정해서 돌아간다.", "기능을 정해서 돌아간다.", "상관 없다."],
    4: ["밥먹고 더할까요?", "내일 마무리 해보죠.", "상대방의 말을 기다린다."],
    5: [],
    6: [],
    7: []
}

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
    if (currentQuestionCount === 8) {
        putAnswers();
    } else if (currentQuestionCount === 5) {
        document.getElementById(`question`).innerHTML = questions[currentQuestionCount]; // question 넣기 - 사실상 title
        await $(`.answerContainer`).empty(); // answerContainer 초기화 - 이전 문제에서 채워졌기 때문

        const answerContainer = document.createElement('div');
        answerContainer.className = "input-answer";
        answerContainer.style.backgroundColor = "#3F4447";
        answerContainer.style.padding = "2rem";

        const firstAnswerTextArea = document.createElement('input'); // 첫번째 정답 textarea 생성
        firstAnswerTextArea.id = "displayName";
        firstAnswerTextArea.placeholder = "DisplayName을 사용하지 않는다면 작성하지 않아도 됩니다.";
        firstAnswerTextArea.style.margin = "0px";
        firstAnswerTextArea.style.width = "29.5rem";
        firstAnswerTextArea.style.height = "2.5rem";
        firstAnswerTextArea.style.fontSize = "1.2rem";

        const secondAnswerTextArea = document.createElement('input'); // 두번째 정답 textarea 생성
        secondAnswerTextArea.id = "methodName";
        secondAnswerTextArea.placeholder = "method명을 입력해주세요.";
        secondAnswerTextArea.style.margin = "0px";
        secondAnswerTextArea.style.width = "13.5rem";
        secondAnswerTextArea.style.height = "2.5rem";
        secondAnswerTextArea.style.fontSize = "1.2rem";

        answerContainer.insertAdjacentHTML("afterbegin", `
        <p style="color: darkgoldenrod">
        <span style="font-size: 1.5rem; color: darkkhaki">자동차 경주 게임에서 자동차의 이름이 5글자를 넘으면 안되는 요구사항에 대한 예외처리 테스트 코드를 작성해보세요.</span>
        </p><br>
         <p style="font-size: 1.5rem; color: darkkhaki"> - 메서드명 : CarNames 클래스의 정적 팩토리 메서드 valueOf()에서 호출하는 validate() 메서드</p>
         <p style="font-size: 1.5rem; color: darkkhaki"> - 입력 : (String type의) carNames</p><br>
         
         <p>
         <span style="font-size: 2rem; color: orange">@DisplayName(<span class="display-name-container"></span>)<br></span> 
         <span style="font-size: 2rem; color: orange">@Test</span>
         </p>
         <p>
         <span style="font-size: 2rem; color: snow">void <span class="method-name-container"></span> <span style="color: #fffafa">() {</span> </span><br>
         <span style="font-size: 2rem; color: darkgrey">...</span><br>
         <span style="font-size: 2rem; color: snow">}</span>
         </p>
        `);

        $(".answerContainer").append(answerContainer);
        $(".answerContainer").css("text-align", "inherit");

        const $displayNameContainer = document.querySelector(".display-name-container");
        const $methodNameContainer = document.querySelector(".method-name-container");

        $displayNameContainer.insertAdjacentElement("afterbegin", firstAnswerTextArea);
        $methodNameContainer.insertAdjacentElement("afterbegin", secondAnswerTextArea);

        var answerButton = document.createElement('button'); // 제출 버튼 생성
        answerButton.className = `answer btn btn-primary`;
        answerButton.id = "btn-save";
        var answerText = document.createTextNode("완료");
        answerButton.appendChild(answerText);

        $(`.answerContainer`).append(answerFormContainer);
        $(`.answerContainer`).append(answerButton);


        await $(`#btn-save`).on(`click`, function () {
            var firstAnswer = $("input#displayName").val();
            var secondAnswer = $("input#methodName").val();

            resultMap[currentQuestionCount++] = {firstAnswer, secondAnswer}; // map에 넣기 (복수개가 들어가네..?!)
            renderPage();
        });
    } else if (currentQuestionCount === 6) {
        document.getElementById(`question`).innerHTML = questions[currentQuestionCount]; // question 넣기 - 사실상 title
        await $(`.answerContainer`).empty(); // answerContainer 초기화 - 이전 문제에서 채워졌기 때문

        const answerContainer = document.createElement('div');
        answerContainer.className = "input-answer";
        answerContainer.style.backgroundColor = "#3F4447";
        answerContainer.style.padding = "2rem";


        const firstAnswerTextArea = document.createElement('input'); // 첫번째 정답 textarea 생성
        firstAnswerTextArea.id = "displayName";
        firstAnswerTextArea.placeholder = "기능 수정에 대한 커밋 메세지를 입력해주세요.";
        firstAnswerTextArea.style.width = "50rem";

        const secondAnswerTextArea = document.createElement('input'); // 두번째 정답 textarea 생성
        secondAnswerTextArea.id = "methodName";
        secondAnswerTextArea.placeholder = "기능 구현에 대한 커밋 메세지를 입력해주세요.";
        secondAnswerTextArea.style.width = "50rem";

        answerContainer.insertAdjacentHTML("afterbegin", `
         <p style="color: snow; font-size: 2rem">자동차 객체들의 위치를 출력하는 기능을 수정했습니다! 커밋할 시간이에요!</p>
         <p style="color: orange; font-size: 1.5rem">
         public void printCars(Cars cars) { <br>
         ...
         <br>
         <span class="display-name-container"></span>
         </p>
         
         
         <p style="color: snow; font-size: 2rem">자동차 생성하는 기능을 구현했습니다! 다음 커밋은요?</p>
         <p style="color: orange; font-size: 1.5rem">
         public Cars create() { <br>
         ...
         <br>
         <span class="method-name-container"></span> 
         </p>
        `);

        $(".answerContainer").append(answerContainer);
        $(".answerContainer").css("text-align", "inherit");

        const $displayNameContainer = document.querySelector(".display-name-container");
        const $methodNameContainer = document.querySelector(".method-name-container");

        $displayNameContainer.insertAdjacentElement("afterbegin", firstAnswerTextArea);
        $methodNameContainer.insertAdjacentElement("afterbegin", secondAnswerTextArea);


        var answerButton = document.createElement('button'); // 제출 버튼 생성
        answerButton.className = `answer btn btn-primary`;
        answerButton.id = "btn-save";
        var answerText = document.createTextNode("완료");
        answerButton.appendChild(answerText);

        $(`.answerContainer`).append(answerFormContainer);
        $(`.answerContainer`).append(answerButton);


        await $(`#btn-save`).on(`click`, function () {
            var firstAnswer = $("input#displayName").val();
            var secondAnswer = $("input#methodName").val();

            resultMap[currentQuestionCount++] = {firstAnswer, secondAnswer}; // map에 넣기 (복수개가 들어가네..?!)
            renderPage();
        });
    } else if (currentQuestionCount === 7) {
        document.getElementById(`question`).innerHTML = questions[currentQuestionCount]; // question 넣기 사실상 title
        await $(`.answerContainer`).empty(); // answerContainer 초기화 - 이전 문제에서 채워졌기 때문

        var answerFormContainer = document.createElement('div'); // 정답을 입력받을 div 생성
        answerFormContainer.className = `answer form`;

        var messageToCrew = document.createElement('input');
        messageToCrew.id = "messageToCrew";
        messageToCrew.placeholder = "소개하는 말을 남겨주세요";

        answerFormContainer.appendChild(messageToCrew);

        var answerButton = document.createElement('button'); // 제출 버튼 생성
        answerButton.className = `answer btn btn-primary`;
        answerButton.id = "btn-save";
        var answerText = document.createTextNode("완료");
        answerButton.appendChild(answerText);

        $(`.answerContainer`).append(answerFormContainer);
        $(`.answerContainer`).append(answerButton);


        await $(`#btn-save`).on(`click`, function () {
            var firstAnswer = $("input#messageToCrew").val();

            resultMap[currentQuestionCount++] = {firstAnswer};
            renderPage();
        });
    } else {
        document.getElementById(`question`).innerHTML = questions[currentQuestionCount];

        await $(`.answerContainer`).empty();
        await answers[currentQuestionCount].forEach((answer) => {
            var answerButton = document.createElement('button');
            answerButton.className = `answer btn btn-primary`;
            var answerText = document.createTextNode(answer);
            answerButton.appendChild(answerText);
            // $(`.answerContainer`).append(answerButton).append(document.createElement(`br`));
            $(`.answerContainer`).append(answerButton);
        });

        await $(`.answer`).on(`click`, function () {
            resultMap[currentQuestionCount++] = $(this).text();
            renderPage();
        });
    }
}

renderPage();
