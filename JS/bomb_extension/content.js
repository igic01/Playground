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
  if(target_div === null){
    console.log('I cannot find the target');
    return;
  }else{
    console.log('target founded!');
  }

  observer = new MutationObserver((mutationsList) => {
      console.log("target_div: ", target_div.innerHTML);  
      fetchData(target_div.innerHTML);
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

    data.sort((a, b) => a.word.length - b.word.length);

    // Handle the sorted data as needed
    console.log(data.map((item) => item.word));
  } catch (error) {
    console.error('Error fetching data:', error);
  }
}
