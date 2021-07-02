import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Notice } from './notice';
import { NoticeService } from './notice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Notice Board';

  public notices: Notice[] = [];
  public editNotice: Notice | undefined;
  public deleteNotice: Notice | undefined;
  public detailsNotice: Notice | undefined;
  public pag = 1;
  public contador = 3;

  constructor(private noticeService: NoticeService) { }
  
  ngOnInit(){
    this.getNotices();
  }

  handlePageChange(event: any) {
    this.pag = event;
  }

  public getNotices(): void {
    this.noticeService.getNoticesList().subscribe(
      (response: Notice[]) => {
        this.notices = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddNotice(addForm: NgForm): void{
    document.getElementById('bt-close-form')?.click();
    this.noticeService.createNotice(addForm.value).subscribe(
      (response: Notice) => {
        console.log(response);
        this.getNotices();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
    console.log(addForm.value);
  }

  public onUpdateNotice(notice: Notice): void{
    document.getElementById('bt2-close-form')?.click();
    this.noticeService.updateNotice(notice).subscribe(
      (response: Notice) => {
        console.log(response);
        this.getNotices();
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onViewNotice(notice: Notice): void{
    this.noticeService.viewNotice(notice).subscribe(
      (response: Notice) => {
        console.log(response);
        this.getNotices();
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteNotice(noticeId: any): void{
    document.getElementById('bt3-close-form')?.click();
    this.noticeService.deleteNotice(noticeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getNotices();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(notice: any, mode: string): void{
    const container = document.getElementById('mainCointainer');


    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if(mode === 'add'){
      button.setAttribute('data-target', '#addNotice');    
    }

    if(mode === 'edit'){
      this.editNotice = notice;
      button.setAttribute('data-target', '#editNotice');    
    }

    if(mode === 'delete'){
      this.deleteNotice = notice;
      button.setAttribute('data-target', '#deleteNotice');    
    }

    if(mode === 'details'){
      this.detailsNotice = notice;
      this.onViewNotice(notice);
      button.setAttribute('data-target', '#detailsNotice');    
    }

    container?.appendChild(button);
    button.click();


  }
}
