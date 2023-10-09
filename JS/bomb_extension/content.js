// content.js

const port = chrome.runtime.connect({ name: "content" });
let observer;

const apiUrl = 'https://api.datamuse.com/words?sp=';

// Listen for messages from the background.js
port.onMessage.addListener((message) => {
  if (message.from === "background.js") {
    // Handle the message from background.js
    if(message.data === "start"){
      console.log("Starting");
      monitorSyllableChanges();
    }else if(message.data === "stop"){
        console.log("Stopping");
        observer.disconnect();
        observer = null; // Reset the observer variable
    }
  }
});

// Function to monitor changes to the innerHTML of elements with class "syllable"
function monitorSyllableChanges() {
  const target_div = document.querySelector(".syllable");

  observer = new MutationObserver((mutationsList) => {
    mutationsList.forEach((mutation) => {
      console.log("target_div new value: ", mutation.target.innerHTML);
      fetchData(mutation.target.innerHTML);
    });
  });

  // Start observing changes on each syllable element
  observer.observe(target_div, { characterData: true, childList: true, subtree: true });
}

async function fetchData(letters) {
  const queryParams = {
    rel_syn: letters
  }

  try {
    
    // Fetch data from the API
    const response = await fetch(apiUrl + '*' + letters + "*");

    // Check if the response is successful (status code 200)
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }

    // Parse the response as JSON
    const data = await response.json();

    // Handle the data as needed
    console.log(data.map(item => item.word));
  } catch (error) {
    console.error('Error fetching data:', error);
  }
}
