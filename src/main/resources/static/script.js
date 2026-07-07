const button = document.getElementById("choose-btn");

button.addEventListener("click", () => {

    document.getElementById("start-screen").style.display = "none";

    document.getElementById("food-screen").style.display = "block";

    fetch("/current")
        .then(response => response.json())
        .then(data => {

            const container = document.getElementById("food-container");

            container.innerHTML = "";

            data.forEach(food => {

                const div = document.createElement("div");

                div.classList.add("food-card");

                div.innerHTML = `
                    <h2>${food.foodName}</h2>

                    <div class="food-image">
                    </div>

                    <button>Byt maträtt</button>
                `;

                container.appendChild(div);
                
            });

        });

});