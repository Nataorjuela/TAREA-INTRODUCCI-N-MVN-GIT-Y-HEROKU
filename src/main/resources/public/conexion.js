let symbolTemporal = getValueInput();
function getValueInput() {
	let inputValue = document.getElementById("domTextElement").value;
	symbolTemporal = document.getElementById("domTextElement").value;
	const divRoot = document.querySelector('#root');
	const divTabla = document.querySelector('#tablaIdentificador');
	const abb = <h1 class="text-uppercase">Microservicio!</h1>
	console.log('Entra ' + symbolTemporal)
	let Api_key = 'RQPYZL4PVD28N3C2';
	let peticion = fetch(`https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=${symbolTemporal}&apikey=${Api_key}`);
	//console.log(symbolTemporal);
	peticion
		.then(resp => resp.json())
		.then(datos => {
			const identi = 'Meta Data';
			const information = '1. Information';
			const symbol = '2. Symbol';
			const refreshed = '3. Last Refreshed';
			const outputSize = '4. Output Size';
			const timeZone = '5. Time Zone';
			const jsonString = datos[identi];
			const tInformation = jsonString[information];
			const tSymbol = jsonString[symbol];
			const tRefreshed = jsonString[refreshed];
			const tOutputSize = jsonString[outputSize];
			const tTimeZone = jsonString[timeZone];
			const respuesta = JSON.stringify(jsonString);
			console.log(jsonString);
			//console.log(datos);
			console.log(jsonString[information])
			//console.log(JSON.stringify(jsonString))
			const tabla = <table class="table table-dark">
				<thead>
					<tr>
						<th>Information</th>
						<th>Symbol</th>
						<th>Last Refreshed</th>
						<th>Output Size</th>
						<th>Time Zone</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>{tInformation}</td>
						<td>{tSymbol}</td>
						<td>{tRefreshed}</td>
						<td>{tOutputSize}</td>
						<td>{tTimeZone}</td>
					</tr>
				</tbody>
			</table>;
			ReactDOM.render(tabla, divTabla);
		})
		.catch(console.warn);

	ReactDOM.render(abb, divRoot);

}