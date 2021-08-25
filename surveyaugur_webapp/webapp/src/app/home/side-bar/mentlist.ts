export class MenuItem {
    constructor(
        public name: string,
        public route: string,
        public toolTip: string,
        public icon: string = '',
    ) {}
}

export const menuList = [
new MenuItem('Createsurvey','home/createsurvey','CreateSurvey','mode'),
new MenuItem('Dashboard','home/dashboard','Dashboard','dashboard'),
new MenuItem('Surveys','home/surveys','Surveys','assignment'),
new MenuItem('Userprofile','home/profile','UserProfile','person'),
new MenuItem('Questiongroups','home/questiongroups','Questiongroups','groups'),
new MenuItem('Request','home/request','Request','swipe'),
new MenuItem('share','home/share','Share','share'),
new MenuItem('Logout','login','Logout','logout')


];



