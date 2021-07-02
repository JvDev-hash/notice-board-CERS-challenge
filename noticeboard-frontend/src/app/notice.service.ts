import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Notice } from './notice';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class NoticeService {

  private baseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  getNotice(id: number): Observable<any> {
    return this.http.get<Notice>(`${this.baseUrl}/find/${id}`);
  }

  createNotice(notice: Notice): Observable<Notice> {
    return this.http.post<Notice>(`${this.baseUrl}/add`, notice);
  }

  updateNotice(value: any): Observable<Notice> {
    return this.http.put<Notice>(`${this.baseUrl}/update`, value);
  }

  viewNotice(value: any): Observable<Notice> {
    return this.http.put<Notice>(`${this.baseUrl}/view`, value);
  }


  deleteNotice(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getNoticesList(): Observable<any> {
    return this.http.get<Notice[]>(`${this.baseUrl}/find/all`);
  }
}