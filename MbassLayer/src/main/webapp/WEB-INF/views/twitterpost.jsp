<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BridgeMbaas</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Montserrat);
/*! normalize.css v4.0.0 | MIT License | github.com/necolas/normalize.css */
html {
	font-family: sans-serif;
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%
}

body {
	margin: 0
}

article, aside, details, figcaption, figure, footer, header, main, menu,
	nav, section, summary {
	display: block
}

audio, canvas, progress, video {
	display: inline-block
}

audio:not ([controls] ){
	display: none;
	height: 0
}

progress {
	vertical-align: baseline
}

template, [hidden] {
	display: none
}

a {
	background-color: transparent
}

a:active, a:hover {
	outline-width: 0
}

abbr[title] {
	border-bottom: none;
	text-decoration: underline;
	text-decoration: underline dotted
}

b, strong {
	font-weight: inherit
}

b, strong {
	font-weight: bolder
}

dfn {
	font-style: italic
}

h1 {
	font-size: 2em;
	margin: 0.67em 0
}

mark {
	background-color: #ff0;
	color: #000
}

small {
	font-size: 80%
}

sub, sup {
	font-size: 75%;
	line-height: 0;
	position: relative;
	vertical-align: baseline
}

sub {
	bottom: -0.25em
}

sup {
	top: -0.5em
}

img {
	border-style: none
}

svg:not (:root ){
	overflow: hidden
}

code, kbd, pre, samp {
	font-family: monospace, monospace;
	font-size: 1em
}

figure {
	margin: 1em 40px
}

hr {
	box-sizing: content-box;
	height: 0;
	overflow: visible
}

button, input, select, textarea {
	font: inherit;
	margin: 0
}

optgroup {
	font-weight: bold
}

button, input, select {
	overflow: visible
}

button, select {
	text-transform: none
}

button, [type="button"], [type="reset"], [type="submit"] {
	cursor: pointer
}

[disabled] {
	cursor: default
}

button, html [type="button"], [type="reset"], [type="submit"] {
	-webkit-appearance: button
}

button::-moz-focus-inner, input::-moz-focus-inner {
	border: 0;
	padding: 0
}

button:-moz-focusring, input:-moz-focusring {
	outline: 1px dotted ButtonText
}

fieldset {
	border: 1px solid #c0c0c0;
	margin: 0 2px;
	padding: 0.35em 0.625em 0.75em
}

legend {
	box-sizing: border-box;
	color: inherit;
	display: table;
	max-width: 100%;
	padding: 0;
	white-space: normal
}

textarea {
	overflow: auto
}

[type="checkbox"], [type="radio"] {
	box-sizing: border-box;
	padding: 0
}

[type="number"]::-webkit-inner-spin-button, [type="number"]::-webkit-outer-spin-button
	{
	height: auto
}

[type="search"] {
	-webkit-appearance: textfield
}

[type="search"]::-webkit-search-cancel-button, [type="search"]::-webkit-search-decoration
	{
	-webkit-appearance: none
}

body {
	display: -webkit-box;
	display: -webkit-flex;
	display: -ms-flexbox;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-webkit-flex-direction: column;
	-ms-flex-direction: column;
	flex-direction: column;
	-webkit-box-align: center;
	-webkit-align-items: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: center;
	-webkit-justify-content: center;
	-ms-flex-pack: center;
	justify-content: center;
	height: 100vh;
	font-family: Montserrat;
	background: #313E50;
}

.text-input {
	position: relative;
	margin-top: 50px;
}

.text-input input[type="text"] {
	display: inline-block;
	width: 500px;
	height: 40px;
	box-sizing: border-box;
	outline: none;
	border: 1px solid lightgray;
	border-radius: 3px;
	padding: 10px 10px 10px 100px;
	-webkit-transition: all 0.1s ease-out;
	transition: all 0.1s ease-out;
}

.text-input input[type="text"]+label {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	height: 40px;
	line-height: 40px;
	color: white;
	border-radius: 3px 0 0 3px;
	padding: 0 20px;
	background: #E03616;
	-webkit-transform: translateZ(0) translateX(0);
	transform: translateZ(0) translateX(0);
	-webkit-transition: all 0.3s ease-in;
	transition: all 0.3s ease-in;
	-webkit-transition-delay: 0.2s;
	transition-delay: 0.2s;
}

.text-input input[type="text"]:focus+label {
	-webkit-transform: translateY(-120%) translateX(0%);
	transform: translateY(-120%) translateX(0%);
	border-radius: 3px;
	-webkit-transition: all 0.1s ease-out;
	transition: all 0.1s ease-out;
}

.text-input input[type="text"]:focus {
	padding: 10px;
	-webkit-transition: all 0.3s ease-out;
	transition: all 0.3s ease-out;
	-webkit-transition-delay: 0.2s;
	transition-delay: 0.2s;
}
</style>
</head>
<body>
	<form action="/MbassLayer/twitterpost" method ="POST">
		<div class="text-input">
			<input type="text" name="tweet" value=""
				placeholder="         Tweet something in here!"> <label
				for="input1">Tweet Here</label> 
				</br>
				</br><input type="submit" value="Post">
		</div>
	</form>
</body>
</html>