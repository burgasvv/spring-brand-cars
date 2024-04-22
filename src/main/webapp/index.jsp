<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <div style="margin-left: 100px; margin-top: 25px; ">
        <h2 style="display: inline-flex"><a style="text-decoration: none" href="">Home</a></h2>
        <h2 style="display: inline-flex; margin-left: 10px"><a style="text-decoration: none" href="brands">Brands</a></h2>
        <h2 style="display: inline-flex; margin-left: 10px"><a style="text-decoration: none" href="cars">Cars</a></h2>
        <form method="get" action="cars/search" style="display: inline-flex; margin-left: 10px">
            <label for="search"></label>
            <input type="text" id="search" name="search">
            <input type="submit" value="Search" style="margin-left: 10px; color: black">
        </form>
    </div>
</body>
</html>
