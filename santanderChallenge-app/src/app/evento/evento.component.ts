import { Component, OnInit } from '@angular/core';
import { Evento } from './evento';
import { EventoService } from './evento.service';

@Component({
  selector: 'app-evento',
  templateUrl: './evento.component.html'
})

export class EventoComponent implements OnInit {
  public eventos: Evento[];
  public temperaturaData:any;
  public cantidadPorPersona:number;
  public cantCervezas:number;
  public temperaturaDataTempCelcius:string;

  constructor(public eventosService: EventoService) {
  }

  ngOnInit() {
      this.temperaturaData = {
        main : {}
      };
      this.getTemperatura();
      this.eventosService.getEventos().subscribe(
        eventos => this.eventos = eventos
      );
  }

  public getTemperatura() {
    fetch("https://community-open-weather-map.p.rapidapi.com/weather?q=buenos%20aires%2Car", {
    	"method": "GET",
    	"headers": {
    		"x-rapidapi-key": "bcdeb16b7emsh4db0e87f0d0d932p1b5fefjsncb5c87ea458c",
    		"x-rapidapi-host": "community-open-weather-map.p.rapidapi.com"
    	}
    })
    .then(response => response.json())
    .then(data => {this.setTemperatura(data);})
  }

  setTemperatura(data){
    this.temperaturaData = data;
    this.temperaturaDataTempCelcius = ((this.temperaturaData.main.temp - 273.15).toFixed(1)).toString();
  }

  getCantidadBebidas(cantidadUsuarios: number, temperaturaHtml: number): number{
    let cantidadPorPersona: number = this.setBooleanCantidad(temperaturaHtml);
    this.cantCervezas=((cantidadUsuarios)*(cantidadPorPersona));
    return Math.ceil((cantidadUsuarios*cantidadPorPersona)/6);
  }

  setBooleanCantidad(temperaturaHtml: number){
    if (temperaturaHtml < 20) {
      return 0.75;
    } else {
      if (temperaturaHtml > 24) {
        return 2;
      } else {
        return 1;
      }
    }
  }

}
