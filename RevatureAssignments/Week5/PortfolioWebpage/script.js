console.log("script.js is running");

const username = "PG-23";

const featuredRepos = ["OffScript", "StreamPulse", "BankOfCLI"];

const url = `https://api.github.com/users/${username}/repos?sort=updated`;

// Grab the empty container from the HTML
const repoList = document.getElementById("repo-list");

// async/await lets us wait for the network request to finish
async function loadRepos() {
  try {
    // 1. Ask the API for data
    const response = await fetch(url);

    // 2. Check that the request worked (status 200-299)
    if (!response.ok) {
      throw new Error(`GitHub responded with ${response.status}`);
    }

    // 3. Convert the response from JSON text into a JavaScript array
    const repos = await response.json();

    // 4. Clear the "Loading..." message
    repoList.innerHTML = "";

    // 5. Build a card for each repo in featuredRepos (features DOM manipulation)
    const selected = repos.filter((repo) => featuredRepos.includes(repo.name));
    selected.forEach((repo) => {
      const card = document.createElement("article");
      card.className = "card";

      card.innerHTML = `
        <h3>${repo.name}</h3>
        <p>${repo.description || "No description yet."}</p>
        <a href="${repo.html_url}" target="_blank" rel="noopener noreferrer">
          View project →
        </a>
      `;

      repoList.appendChild(card);
    });
  } catch (error) {
    // Show a friendly message if something goes wrong
    repoList.innerHTML = "<p>Couldn't load projects right now.</p>";
    console.error(error);
  }
}

loadRepos();