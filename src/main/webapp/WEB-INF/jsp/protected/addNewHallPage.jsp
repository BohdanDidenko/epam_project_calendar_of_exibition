<html>
<body>
<h2>Add new hall page!
    <br>
    <p><a href="https://localhost:9000/protected/adminPage">Admin page</a></p>
</h2>
<form action="protected/addNewHall" method="POST" enctype="multipart/form-data">

    Cost: <input type="text" name="name">
    <br>
    <br>
    Name event: <input type="time" name="StartTime">
    <br>
    <br>
    Start Time: <input type="time"  name="EndTime">
    <br>
    <br>
    Free places: <input type="text"  name="freePlaces">
    <br>
    <br>
    Free date: <input id="freeDate" name="freeDate" min="2017-01-01" max="2025-01-01" type="date">
    <br>
    <br>
    Is available: <input id="isAvailable" name="isAvailable"  type="checkbox">
    <br>
    <br>
    <div>
        <button class="new" type="submit" name="add" value="addNewHall">Add new hall</button>
    </div>
</form>
</body>
</html>