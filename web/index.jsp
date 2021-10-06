<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="/css/header.css">
  <link rel="stylesheet" type="text/css" href="/css/body.css">
  <title>Ana's Web</title>
</head>

<body>
<table id="body-table">
  <tr>
    <th class="header">
      <div>
        <p>Морозова Анастасия Александровна P3230</p>
        <p>Вариант 30610</p>
      </div>
    </th>
  </tr>

  <tr class="body">
    <th class="choose-area">
      <div class="graph">
          <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg">


            <line stroke="black" x1="0" y1="150" x2="300" y2="150"></line>
            <line stroke="black" x1="150" y1="0" x2="150" y2="300"></line>
            <polygon fill="black" points="150,0 144,15 156,15" stroke="black"></polygon>
            <polygon fill="black" points="300,150 285,156 285,144" stroke="black"></polygon>

            <!-- Деления -->
            <line stroke="black" x1="200" y1="155" x2="200" y2="145"></line>
            <line stroke="black" x1="250" y1="155" x2="250" y2="145"></line>

            <line stroke="black" x1="50" y1="155" x2="50" y2="145"></line>
            <line stroke="black" x1="100" y1="155" x2="100" y2="145"></line>

            <line stroke="black" x1="145" y1="100" x2="155" y2="100"></line>
            <line stroke="black" x1="145" y1="50" x2="155" y2="50"></line>

            <line stroke="black" x1="145" y1="200" x2="155" y2="200"></line>
            <line stroke="black" x1="145" y1="250" x2="155" y2="250"></line>

            <!-- Подписи к делениям и осям -->
            <text fill="black" x="195" y="140">R/2</text>
            <text fill="black" x="250" y="140">R</text>

            <text fill="black" x="40" y="140">-R</text>
            <text fill="black" x="85" y="140">-R/2</text>

            <text fill="black" x="160" y="55">R</text>
            <text fill="black" x="160" y="105">R/2</text>

            <text fill="black" x="160" y="204">-R/2</text>
            <text fill="black" x="160" y="255">-R</text>

            <text fill="black" x="285" y="140">X</text>
            <text fill="black" x="160" y="15">Y</text>

            <!-- Треугольник (1 четверть) -->
            <polygon fill="blue"
                     fill-opacity="0.2"
                     stroke="blue"
                     points="150,150 200,150 150,50"></polygon>

            <!-- Круг (2 четверть) -->
            <path fill="blue"
                  fill-opacity="0.2"
                  stroke="blue"
                  d="M 50 150 A 100 100, 90, 0, 0, 150 250 L 150 150 Z"></path>

            <!-- Прямоугольник (4 четверть) -->
            <polygon fill="blue"
                     fill-opacity="0.2"
                     stroke="blue"
                     points="150,150 250,150 250,200 150,200"></polygon>

            <!-- Здесь будут точки на графике -->

          </svg>
      </div>
      <form id="coordinates-form" method="post">
        <div class="checkbox-area">
          <p>Выберите X:</p>
          <div class="x">
            <label>-3<input type="checkbox" name="x" value="-3" onclick="controlCheckbox(this)"></label>
            <label>-2<input type="checkbox" name="x" value="-2" onclick="controlCheckbox(this)"></label>
            <label>-1<input type="checkbox" name="x" value="-1" onclick="controlCheckbox(this)"></label>
            <label>0<input type="checkbox" name="x" value="0" onclick="controlCheckbox(this)" checked></label>
            <label>1<input type="checkbox" name="x" value="1" onclick="controlCheckbox(this)"></label>
            <label>2<input type="checkbox" name="x" value="2" onclick="controlCheckbox(this)"></label>
            <label>3<input type="checkbox" name="x" value="3" onclick="controlCheckbox(this)"></label>
            <label>4<input type="checkbox" name="x" value="4" onclick="controlCheckbox(this)"></label>
            <label>5<input type="checkbox" name="x" value="5" onclick="controlCheckbox(this)"></label>
          </div>

          <p>Выберите Y:</p>
          <div class="y">
            <input id="yField" type="text" name="y" required="" placeholder="Число в интервале (-5;3)">
          </div>

          <p>Выберите R:</p>
          <div class="r">
            <label>1<input type="checkbox" name="r" value="1" onclick="controlCheckbox(this)" checked></label>
            <label>2<input type="checkbox" name="r" value="2" onclick="controlCheckbox(this)"></label>
            <label>3<input type="checkbox" name="r" value="3" onclick="controlCheckbox(this)"></label>
            <label>4<input type="checkbox" name="r" value="4" onclick="controlCheckbox(this)"></label>
            <label>5<input type="checkbox" name="r" value="5" onclick="controlCheckbox(this)"></label>
          </div>

          <div class="buttons-area">
            <button id="function-btn" type="submit" class="gradient-button" name="submit">Отправить</button>
          </div>
        </div>
      </form>
    </th>
  </tr>

  <tr>
    <th>
      <form method="post">
        <button type="submit" class="gradient-button" name="clear">Очистить</button>
      </form>
      <div class="table-area">
        <table id="main-table">
          <caption>История выполнений</caption>
          <tr>
            <th class="col">X</th>
            <th class="col">Y</th>
            <th class="col">R</th>
            <th class="col">Текущее время</th>
            <th class="col">Время исполнения</th>
            <th class="col">Результат</th>
          </tr>
        </table>
      </div>
    </th>
  </tr>
</table>

<script src="/js/validate.js"></script>
</body>
</html>