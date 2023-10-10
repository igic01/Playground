// popup.js
const b_start = document.getElementById("b_start");

chrome.storage.local.get("switch_status", function (data) {
  console.log(data.switch_status);
  if (data.switch_status === undefined) {
    chrome.storage.local.set({ switch_status: false });
  } else {
    if (data.switch_status === false) {
      b_start.innerHTML = "Press to start";
    } else if (data.switch_status === true) {
      b_start.innerHTML = "Press to stop";
    }
  }
});

b_start.addEventListener("click", () => {
  console.log("Clicked", chrome.storage.local.get("switch_status"));
  chrome.storage.local.get("switch_status", function (data) {
    if (data.switch_status === false) {
      chrome.storage.local.set({ switch_status: true });
      chrome.runtime.sendMessage({ from: "popup.js", data: "start" });
      

      b_start.innerHTML = "Press to stop";
      console.log("Pressed start");
    } else if (data.switch_status === true) {
      chrome.storage.local.set({ switch_status: false });
      chrome.runtime.sendMessage({ from: "popup.js", data: "stop" });

      b_start.innerHTML = "Press to start";
      console.log("Pressed stop");
    }
  });
});
