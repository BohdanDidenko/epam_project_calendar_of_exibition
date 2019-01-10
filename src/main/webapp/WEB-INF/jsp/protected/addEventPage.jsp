<html>
<body>
<h2>Add event page!
<br>
    <p><a href="https://localhost:9000/protected/adminPage">Admin page</a></p>
</h2>
<form action="protected/addEvent" method="POST" enctype="multipart/form-data">

    Cost: <input type="text" name="price">
    <br>
    <br>
    Name event: <input type="text" name="nameExposition">
    <br>
    <br>
    Short description: <textarea  name="shortDescription"></textarea>
    <br>
    <br>
    Description: <textarea  name="description"></textarea>
    <br>
    <br>
    Select image to upload: <input type="file" name="file" id="file">
    <br>
    <br>
    Start date: <input id="startDate" name="startDate" min="2017-01-01" max="2025-01-01" type="date">
    <br>
    <br>
    End date: <input id="endDate" name="endDate" min="2017-01-01" max="2025-01-01" type="date">
    <br>
    <br>
    Name of hall:
    <br>
    <input type="checkbox" name="nameHall"  value="hallOne" >hall One<br>
    <input type="checkbox" name="nameHall"  value="hallTwo" >hall Two<br>
    <input type="checkbox" name="nameHall"  value="hallThree" >hall Three<br>
    <br>
    <br>
    <div>
        <button class="new" type="submit" name="add" value="buyTicket">Add new exposition</button>
    </div>
</form>
</body>
</html>