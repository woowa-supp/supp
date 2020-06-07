import {
  descriptionTemplate,
  developerTemplate,
  quotesTemplate,
  wisdomTemplate
} from "./templates.js"

function TypeResult() {
  const requestType = async () => {
    return await $.ajax({
      type: 'GET',
      url: '/api/v1/result',
      dataType: 'json',
    })
  }

  this.init = async () => {
    const type = await requestType();

    const $header = document.querySelector(".developer-type");
    $header.insertAdjacentText('afterbegin', developerTemplate(type));

    const $description = document.querySelector(".description");
    $description.insertAdjacentHTML("afterbegin", descriptionTemplate(type));

    const $quotes = document.querySelector(".quotes");
    $quotes.insertAdjacentHTML("afterbegin", quotesTemplate(type));

    const $wisdom = document.querySelector(".wisdom");
    $wisdom.insertAdjacentHTML("afterbegin", wisdomTemplate(type));
  }
}

const typeResult = new TypeResult();
typeResult.init();
