// Function to fetch data from the API

async function fetchData() {
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

// Function to render data in cards
async function renderData() {
    const container = document.querySelector('.author-container');
    const loadMoreButton = document.getElementById('load-more');
    
    // Fetch the number of cards to show from the data attribute
    const cardsToShow = parseInt(loadMoreButton.dataset.cardsToShow, 10); // Use the value from the data attribute
    
    let currentIndex = 0;

    // Fetch data from the API
    const data = await fetchData();

    if (!data) {
        return;
    }

    // Function to show a chunk of cards
    function showCards(startIndex, endIndex) {
        for (let i = startIndex; i < endIndex && i < data.length; i++) {
            const item = data[i];
            const card = document.createElement('div');
            card.classList.add('card');

            const title = document.createElement('h2');
            title.textContent = item.title;

            const body = document.createElement('p');
            body.textContent = item.body;

            card.appendChild(title);
            card.appendChild(body);
            container.appendChild(card);
        }
    }

    // Initially show the first 'cardsToShow' cards (including the default ones)
    showCards(currentIndex, currentIndex + cardsToShow);
    currentIndex += cardsToShow;

    // Load more cards when the button is clicked
    loadMoreButton.addEventListener('click', function () {
        showCards(currentIndex, currentIndex + cardsToShow);
        currentIndex += cardsToShow;

        // Hide the "Load More" button if all cards are loaded
        if (currentIndex >= data.length) {
            loadMoreButton.style.display = 'none';
        }
    });

    // Initially hide the "Load More" button if all data is already rendered
    if (currentIndex >= data.length) {
        loadMoreButton.style.display = 'none';
    }
}

// Call the renderData function to display data
renderData();
