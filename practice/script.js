let noOfTopics = 0;
let noOfguesses = 0;

let names = [];
let initialNames = [];
let chancesPerUser = 0;
let maxChancesDict = {};

const removeUserHavingMaxChances = () => {
  for (const key of Object.keys(maxChancesDict)) {
    if (maxChancesDict[key] >= chancesPerUser) {
      let tempNames = names.filter((name) => name != key);
      names = tempNames;
      delete maxChancesDict[key];
    }
  }

  console.log(maxChancesDict);
};

const checkUsersMaxLimitReached = () => {
  return Object.keys(maxChancesDict).length === 0;
};

const constructDictWithInitialValues = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    maxChancesDict[arr[i]] = 0;
  }
  console.log(maxChancesDict);
};

const lockData = () => {
  let topicsInputField = document.querySelector("#topics");

  if (topicsInputField.value && Number(topicsInputField.value) > 0) {
    noOfTopics = topicsInputField.value;
    noOfguesses = noOfTopics;
  } else {
    alert("Enter Valid No of topics (Number should be min of 1)");
    return;
  }
  let namesInputField = document.querySelector("#names");
  if (namesInputField.value.length) {
    names = namesInputField.value.split(",");
    initialNames = [...names];
    constructDictWithInitialValues(initialNames);
  } else {
    alert("Names field should not be empty");
    return;
  }
  document.querySelector("section").innerHTML = ``;
  chancesPerUser = Math.floor(noOfTopics / names.length);
};

let index = 1;

const guessRandomMember = () => {
  if (noOfguesses) {
    if (!checkUsersMaxLimitReached()) {
      let randomNumber = Math.floor(Math.random() * names.length);
      let guessedMember = names[randomNumber] || "Not found";
      let sectiontag = document.querySelector("section");
      let divTag = document.createElement("div");
      divTag.innerText = index + " ) " + guessedMember;
      divTag.classList.add("guesseduser");
      sectiontag.appendChild(divTag);
      if (guessedMember !== "Not found") {
        noOfguesses--;
        if (guessedMember in maxChancesDict) {
          maxChancesDict[guessedMember]++;
          removeUserHavingMaxChances();
        }
        index++;
      }
    } else {
      let randomNumber = Math.floor(Math.random() * initialNames.length);

      let guessedMember = initialNames[randomNumber] || "Not found";
      let sectiontag = document.querySelector("section");
      let divTag = document.createElement("div");
      divTag.innerText = index + " ) " + guessedMember;
      divTag.classList.add("guesseduser");
      sectiontag.appendChild(divTag);
      noOfguesses--;
      index++;
    }
    document.querySelector(
      "textarea"
    ).innerText = `${noOfguesses} random guesses left - ${chancesPerUser} max chances per person`;
  }

  console.log(maxChancesDict);
};
