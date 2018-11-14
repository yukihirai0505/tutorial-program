(function() {
  var form = document.getElementById("form"),
    result = document.getElementById("result");
  form.addEventListener("submit", function (e) {
    e.preventDefault();
    var gender = getRadioValue("gender");
    var generation = getRadioValue("generation");
    var resultMessage = "普通ですね";
    // ランダムメッセージ
    //var messages = ["あ", "い", "う", "え", "お"];
    //var resultMessage = messages[Math.floor(Math.random() * messages.length)];
    // 配列を使用
    //var resultMessage = resultMessages[gender][generation];
    if (gender === "1" && generation === "1") {
      resultMessage = "あなたは私のタイプです";
    }
    result.textContent = resultMessage;
    // result.style.color = 'red';
    // result.className = 'myStyle';
  }, false);

  function getRadioValue(theRadioGroup) {
    var elements = document.getElementsByName(theRadioGroup);
    for (var i = 0, l = elements.length; i < l; i++) {
      if (elements[i].checked) {
        return elements[i].value;
      }
    }
  }

  var resultMessages = [
    [
      "Male10",
      "Male20",
      "Male30",
      "MaleOver40"
    ],
    [
      "Female10",
      "Female20",
      "Female30",
      "FemaleOver40"
    ],
    [
      "Other10",
      "Other20",
      "Other30",
      "OtherOver40"
    ]
  ];

  /*
  document.addEventListener('click', function() {
    var greet = document.createElement('p'),
      text = document.createTextNode('クリックしちゃだめ');
    document.body.appendChild(greet).appendChild(text);
  }, false);
  */

  /*
  document.getElementById('dangerBtn').addEventListener('click', function(e) {
    var p = document.createElement('p'),
      text = document.createTextNode('ふりじゃないって！');
    document.body.appendChild(p).appendChild(text);
  }, false);
  */
})();