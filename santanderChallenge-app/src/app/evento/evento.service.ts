import { Injectable } from '@angular/core';
import { Evento } from './evento';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class EventoService {
  public urlEndPointGetEventos: string = 'http://localhost:8080/api/secure/eventos';
  constructor(public http: HttpClient) { }

  getEventos(): Observable<Evento[]> {
    return this.http.get<Evento[]>(this.urlEndPointGetEventos);
  }
}
