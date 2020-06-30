


var SEARCH_PARSER=function(){"use strict";function e(e,t){function r(){this.constructor=e}r.prototype=t.prototype,e.prototype=new r}function t(e,r,n,u){this.message=e,this.expected=r,this.found=n,this.location=u,this.name="SyntaxError","function"==typeof Error.captureStackTrace&&Error.captureStackTrace(this,t)}function r(e){function r(t){var r,n,u=gr[t];if(u)return u;for(r=t-1;!gr[r];)r--;for(u=gr[r],u={line:u.line,column:u.column,seenCR:u.seenCR};t>r;)n=e.charAt(r),"\n"===n?(u.seenCR||u.line++,u.column=1,u.seenCR=!1):"\r"===n||"\u2028"===n||"\u2029"===n?(u.line++,u.column=1,u.seenCR=!0):(u.column++,u.seenCR=!1),r++;return gr[t]=u,u}function n(e,t){var n=r(e),u=r(t);return{start:{offset:e,line:n.line,column:n.column},end:{offset:t,line:u.line,column:u.column}}}function u(e){Sr>Rr||(Rr>Sr&&(Sr=Rr,Dr=[]),Dr.push(e))}function s(e,r,n,u){function s(e){var t=1;for(e.sort(function(e,t){return e.description<t.description?-1:e.description>t.description?1:0});t<e.length;)e[t-1]===e[t]?e.splice(t,1):t++}function i(e,t){function r(e){function t(e){return e.charCodeAt(0).toString(16).toUpperCase()}return e.replace(/\\/g,"\\\\").replace(/"/g,'\\"').replace(/\x08/g,"\\b").replace(/\t/g,"\\t").replace(/\n/g,"\\n").replace(/\f/g,"\\f").replace(/\r/g,"\\r").replace(/[\x00-\x07\x0B\x0E\x0F]/g,function(e){return"\\x0"+t(e)}).replace(/[\x10-\x1F\x80-\xFF]/g,function(e){return"\\x"+t(e)}).replace(/[\u0100-\u0FFF]/g,function(e){return"\\u0"+t(e)}).replace(/[\u1000-\uFFFF]/g,function(e){return"\\u"+t(e)})}var n,u,s,i=Array(e.length);for(s=0;s<e.length;s++)i[s]=e[s].description;return n=e.length>1?i.slice(0,-1).join(", ")+" or "+i[e.length-1]:i[0],u=t?'"'+r(t)+'"':"end of input","Expected "+n+" but "+u+" found."}return null!==r&&s(r),new t(null!==e?e:i(r,n),r,n,u)}function i(){var e,t,r=25*Rr+0,n=wr[r];if(n)return Rr=n.nextPos,n.result;if(e=[],t=o(),t===O&&(t=l(),t===O&&(t=a(),t===O&&(t=c(),t===O&&(t=d(),t===O&&(t=y(),t===O&&(t=x(),t===O&&(t=v(),t===O&&(t=h(),t===O&&(t=f(),t===O&&(t=p(),t===O&&(t=g(),t===O&&(t=A())))))))))))),t!==O)for(;t!==O;)e.push(t),t=o(),t===O&&(t=l(),t===O&&(t=a(),t===O&&(t=c(),t===O&&(t=d(),t===O&&(t=y(),t===O&&(t=x(),t===O&&(t=v(),t===O&&(t=h(),t===O&&(t=f(),t===O&&(t=p(),t===O&&(t=g(),t===O&&(t=A()))))))))))));else e=O;return wr[r]={nextPos:Rr,result:e},e}function o(){var e,t,r,n,u=25*Rr+1,s=wr[u];if(s)return Rr=s.nextPos,s.result;if(e=Rr,t=S(),t!==O){for(r=[],n=g();n!==O;)r.push(n),n=g();r!==O?(n=P(),n===O&&(n=T()),n===O&&(n=null),n!==O?(Cr=e,t=B(t,n),e=t):(Rr=e,e=O)):(Rr=e,e=O)}else Rr=e,e=O;return wr[u]={nextPos:Rr,result:e},e}function l(){var t,r,n,s,i=25*Rr+2,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,2)===G?(r=G,Rr+=2):(r=O,0===Tr&&u(L)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=C(),s===O&&(s=R(),s===O&&(s=T())),s!==O?(Cr=t,r=U(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function a(){var t,r,n,s,i=25*Rr+3,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,2)===H?(r=H,Rr+=2):(r=O,0===Tr&&u(V)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=C(),s===O&&(s=T()),s!==O?(Cr=t,r=K(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function c(){var t,r,n,s,i=25*Rr+4,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,7)===Y?(r=Y,Rr+=7):(r=O,0===Tr&&u(j)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=P(),s===O&&(s=T()),s!==O?(Cr=t,r=W(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function p(){var t,r,n,s,i=25*Rr+5,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,10)===M?(r=M,Rr+=10):(r=O,0===Tr&&u(X)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=C(),s===O&&(s=T()),s!==O?(Cr=t,r=q(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function f(){var t,r,n,s,i=25*Rr+6,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,7)===z?(r=z,Rr+=7):(r=O,0===Tr&&u(J)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=P(),s===O&&(s=T()),s!==O?(Cr=t,r=Q(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function d(){var t,r,n,s,i=25*Rr+7,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,7)===Z?(r=Z,Rr+=7):(r=O,0===Tr&&u($)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=C(),s===O&&(s=R(),s===O&&(s=T())),s!==O?(Cr=t,r=et(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function v(){var t,r,n,s,i,o,l=25*Rr+8,a=wr[l];if(a)return Rr=a.nextPos,a.result;if(t=Rr,e.substr(Rr,6)===tt?(r=tt,Rr+=6):(r=O,0===Tr&&u(rt)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();if(n!==O)if(58===e.charCodeAt(Rr)?(s=nt,Rr++):(s=O,0===Tr&&u(ut)),s!==O){for(i=[],o=g();o!==O;)i.push(o),o=g();i!==O?(o=E(),o!==O?(Cr=t,r=st(o),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;else Rr=t,t=O}else Rr=t,t=O;return wr[l]={nextPos:Rr,result:t},t}function h(){var t,r,n,s,i,o,l=25*Rr+9,a=wr[l];if(a)return Rr=a.nextPos,a.result;if(t=Rr,e.substr(Rr,8)===it?(r=it,Rr+=8):(r=O,0===Tr&&u(ot)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();if(n!==O)if(58===e.charCodeAt(Rr)?(s=nt,Rr++):(s=O,0===Tr&&u(ut)),s!==O){for(i=[],o=g();o!==O;)i.push(o),o=g();i!==O?(o=m(),o!==O?(Cr=t,r=lt(o),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;else Rr=t,t=O}else Rr=t,t=O;return wr[l]={nextPos:Rr,result:t},t}function y(){var t,r,n,s,i=25*Rr+10,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,9)===at?(r=at,Rr+=9):(r=O,0===Tr&&u(ct)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=R(),s===O&&(s=T()),s!==O?(Cr=t,r=pt(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function x(){var t,r,n,s,i=25*Rr+11,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,e.substr(Rr,3)===ft?(r=ft,Rr+=3):(r=O,0===Tr&&u(dt)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=P(),s===O&&(s=T()),s!==O?(Cr=t,r=vt(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function P(){var t,r,n,s,i=25*Rr+12,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,58===e.charCodeAt(Rr)?(r=nt,Rr++):(r=O,0===Tr&&u(ut)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=b(),s!==O?(Cr=t,r=ht(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function A(){var e,t,r=25*Rr+13,n=wr[r];return n?(Rr=n.nextPos,n.result):(e=Rr,t=F(),t===O&&(t=w()),t!==O&&(Cr=e,t=yt(t)),e=t,wr[r]={nextPos:Rr,result:e},e)}function E(){var t,r=25*Rr+14,n=wr[r];return n?(Rr=n.nextPos,n.result):(e.substr(Rr,4)===xt?(t=xt,Rr+=4):(t=O,0===Tr&&u(Pt)),t===O&&(e.substr(Rr,6)===At?(t=At,Rr+=6):(t=O,0===Tr&&u(Et)),t===O&&(e.substr(Rr,7)===mt?(t=mt,Rr+=7):(t=O,0===Tr&&u(bt)),t===O&&(e.substr(Rr,8)===Rt?(t=Rt,Rr+=8):(t=O,0===Tr&&u(Ct))))),wr[r]={nextPos:Rr,result:t},t)}function m(){var t,r=25*Rr+15,n=wr[r];return n?(Rr=n.nextPos,n.result):(e.substr(Rr,5)===gt?(t=gt,Rr+=5):(t=O,0===Tr&&u(St)),t===O&&(e.substr(Rr,7)===Dt?(t=Dt,Rr+=7):(t=O,0===Tr&&u(Tt)),t===O&&(e.substr(Rr,7)===mt?(t=mt,Rr+=7):(t=O,0===Tr&&u(bt)),t===O&&(e.substr(Rr,5)===wt?(t=wt,Rr+=5):(t=O,0===Tr&&u(Ft))))),wr[r]={nextPos:Rr,result:t},t)}function b(){var t,r=25*Rr+16,n=wr[r];return n?(Rr=n.nextPos,n.result):(e.substr(Rr,4)===It?(t=It,Rr+=4):(t=O,0===Tr&&u(Nt)),t===O&&(e.substr(Rr,5)===Ot?(t=Ot,Rr+=5):(t=O,0===Tr&&u(kt)),t===O&&(e.substr(Rr,9)===_t?(t=_t,Rr+=9):(t=O,0===Tr&&u(Bt)),t===O&&(e.substr(Rr,8)===Gt?(t=Gt,Rr+=8):(t=O,0===Tr&&u(Lt)),t===O&&(e.substr(Rr,9)===Ut?(t=Ut,Rr+=9):(t=O,0===Tr&&u(Ht)),t===O&&(e.substr(Rr,10)===Vt?(t=Vt,Rr+=10):(t=O,0===Tr&&u(Kt)),t===O&&(e.substr(Rr,9)===Yt?(t=Yt,Rr+=9):(t=O,0===Tr&&u(jt)),t===O&&(e.substr(Rr,10)===Wt?(t=Wt,Rr+=10):(t=O,0===Tr&&u(Mt)),t===O&&(e.substr(Rr,13)===Xt?(t=Xt,Rr+=13):(t=O,0===Tr&&u(qt)),t===O&&(e.substr(Rr,14)===zt?(t=zt,Rr+=14):(t=O,0===Tr&&u(Jt)),t===O&&(e.substr(Rr,9)===Qt?(t=Qt,Rr+=9):(t=O,0===Tr&&u(Zt)),t===O&&(e.substr(Rr,10)===$t?(t=$t,Rr+=10):(t=O,0===Tr&&u(er))))))))))))),wr[r]={nextPos:Rr,result:t},t)}function R(){var t,r,n,s,i=25*Rr+17,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,58===e.charCodeAt(Rr)?(r=nt,Rr++):(r=O,0===Tr&&u(ut)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(e.substr(Rr,10)===tr?(s=tr,Rr+=10):(s=O,0===Tr&&u(rr)),s!==O?(Cr=t,r=nr(),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function C(){var t,r,n,s,i=25*Rr+18,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,58===e.charCodeAt(Rr)?(r=nt,Rr++):(r=O,0===Tr&&u(ut)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(e.substr(Rr,2)===ur?(s=ur,Rr+=2):(s=O,0===Tr&&u(sr)),s!==O?(Cr=t,r=ir(),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function g(){var t,r,n,s=25*Rr+19,i=wr[s];if(i)return Rr=i.nextPos,i.result;if(t=Rr,r=[],32===e.charCodeAt(Rr)?(n=or,Rr++):(n=O,0===Tr&&u(lr)),n!==O)for(;n!==O;)r.push(n),32===e.charCodeAt(Rr)?(n=or,Rr++):(n=O,0===Tr&&u(lr));else r=O;return r!==O&&(Cr=t,r=ar()),t=r,wr[s]={nextPos:Rr,result:t},t}function S(){var t,r,n,s=25*Rr+20,i=wr[s];return i?(Rr=i.nextPos,i.result):(t=Rr,35===e.charCodeAt(Rr)?(r=cr,Rr++):(r=O,0===Tr&&u(pr)),r!==O?(n=D(),n===O&&(n=F()),n!==O?(Cr=t,r=fr(n),t=r):(Rr=t,t=O)):(Rr=t,t=O),wr[s]={nextPos:Rr,result:t},t)}function D(){var t,r,n,s=25*Rr+21,i=wr[s];if(i)return Rr=i.nextPos,i.result;if(t=Rr,r=[],dr.test(e.charAt(Rr))?(n=e.charAt(Rr),Rr++):(n=O,0===Tr&&u(vr)),n!==O)for(;n!==O;)r.push(n),dr.test(e.charAt(Rr))?(n=e.charAt(Rr),Rr++):(n=O,0===Tr&&u(vr));else r=O;return r!==O&&(Cr=t,r=hr(r)),t=r,wr[s]={nextPos:Rr,result:t},t}function T(){var t,r,n,s,i=25*Rr+22,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,58===e.charCodeAt(Rr)?(r=nt,Rr++):(r=O,0===Tr&&u(ut)),r!==O){for(n=[],s=g();s!==O;)n.push(s),s=g();n!==O?(s=F(),s===O&&(s=w()),s!==O?(Cr=t,r=yr(s),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}function w(){var t,r,n,s=25*Rr+23,i=wr[s];if(i)return Rr=i.nextPos,i.result;if(t=Rr,r=[],xr.test(e.charAt(Rr))?(n=e.charAt(Rr),Rr++):(n=O,0===Tr&&u(Pr)),n!==O)for(;n!==O;)r.push(n),xr.test(e.charAt(Rr))?(n=e.charAt(Rr),Rr++):(n=O,0===Tr&&u(Pr));else r=O;return r!==O&&(Cr=t,r=hr(r)),t=r,wr[s]={nextPos:Rr,result:t},t}function F(){var t,r,n,s,i=25*Rr+24,o=wr[i];if(o)return Rr=o.nextPos,o.result;if(t=Rr,39===e.charCodeAt(Rr)?(r=Ar,Rr++):(r=O,0===Tr&&u(Er)),r!==O){for(n=[],mr.test(e.charAt(Rr))?(s=e.charAt(Rr),Rr++):(s=O,0===Tr&&u(br));s!==O;)n.push(s),mr.test(e.charAt(Rr))?(s=e.charAt(Rr),Rr++):(s=O,0===Tr&&u(br));n!==O?(39===e.charCodeAt(Rr)?(s=Ar,Rr++):(s=O,0===Tr&&u(Er)),s!==O?(Cr=t,r=hr(n),t=r):(Rr=t,t=O)):(Rr=t,t=O)}else Rr=t,t=O;return wr[i]={nextPos:Rr,result:t},t}var I,N=arguments.length>1?arguments[1]:{},O={},k={start:i},_=i,B=function(e,t){return{type:"USER_LABEL",name:e,value:t}},G="to",L={type:"literal",value:"to",description:'"to"'},U=function(e){return{type:"ASSIGNED",name:"to",value:e}},H="by",V={type:"literal",value:"by",description:'"by"'},K=function(e){return{type:"CREATED_BY",name:"by",value:e}},Y="created",j={type:"literal",value:"created",description:'"created"'},W=function(e){return{type:"CREATED",name:"created",value:e}},M="updated_by",X={type:"literal",value:"updated_by",description:'"updated_by"'},q=function(e){return{type:"UPDATED_BY",name:"updated_by",value:e}},z="updated",J={type:"literal",value:"updated",description:'"updated"'},Q=function(e){return{type:"UPDATED",name:"updated",value:e}},Z="watched",$={type:"literal",value:"watched",description:'"watched"'},et=function(e){return{type:"WATCHED_BY",name:"watched",value:e}},tt="status",rt={type:"literal",value:"status",description:'"status"'},nt=":",ut={type:"literal",value:":",description:'":"'},st=function(e){return{type:"STATUS",name:"status",value:{type:"STRING",originalValue:e,value:e}}},it="location",ot={type:"literal",value:"location",description:'"location"'},lt=function(e){return{type:"LOCATION",name:"location",value:{type:"STRING",originalValue:e,value:e}}},at="milestone",ct={type:"literal",value:"milestone",description:'"milestone"'},pt=function(e){return{type:"MILESTONE",name:"milestone",value:e}},ft="due",dt={type:"literal",value:"due",description:'"due"'},vt=function(e){return{type:"DUE_DATE",name:"due",value:e}},ht=function(e){return{type:"DATE_IDENTIFIER",value:e}},yt=function(e){return{type:"FREETEXT",value:{type:"STRING",value:e}}},xt="OPEN",Pt={type:"literal",value:"OPEN",description:'"OPEN"'},At="CLOSED",Et={type:"literal",value:"CLOSED",description:'"CLOSED"'},mt="BACKLOG",bt={type:"literal",value:"BACKLOG",description:'"BACKLOG"'},Rt="DEFERRED",Ct={type:"literal",value:"DEFERRED",description:'"DEFERRED"'},gt="BOARD",St={type:"literal",value:"BOARD",description:'"BOARD"'},Dt="ARCHIVE",Tt={type:"literal",value:"ARCHIVE",description:'"ARCHIVE"'},wt="TRASH",Ft={type:"literal",value:"TRASH",description:'"TRASH"'},It="late",Nt={type:"literal",value:"late",description:'"late"'},Ot="today",kt={type:"literal",value:"today",description:'"today"'},_t="yesterday",Bt={type:"literal",value:"yesterday",description:'"yesterday"'},Gt="tomorrow",Lt={type:"literal",value:"tomorrow",description:'"tomorrow"'},Ut="this week",Ht={type:"literal",value:"this week",description:'"this week"'},Vt="this month",Kt={type:"literal",value:"this month",description:'"this month"'},Yt="next week",jt={type:"literal",value:"next week",description:'"next week"'},Wt="next month",Mt={type:"literal",value:"next month",description:'"next month"'},Xt="previous week",qt={type:"literal",value:"previous week",description:'"previous week"'},zt="previous month",Jt={type:"literal",value:"previous month",description:'"previous month"'},Qt="last week",Zt={type:"literal",value:"last week",description:'"last week"'},$t="last month",er={type:"literal",value:"last month",description:'"last month"'},tr="unassigned",rr={type:"literal",value:"unassigned",description:'"unassigned"'},nr=function(){return{type:"UNASSIGNED",originalValue:"unassigned",value:"UNASSIGNED"}},ur="me",sr={type:"literal",value:"me",description:'"me"'},ir=function(){return{type:"CURRENT_USER",value:"me"}},or=" ",lr={type:"literal",value:" ",description:'" "'},ar=function(){return{type:"WHITE_SPACE"}},cr="#",pr={type:"literal",value:"#",description:'"#"'},fr=function(e){return e},dr=/^[^'\\' :']/i,vr={type:"class",value:"[^'\\\\' :']i",description:"[^'\\\\' :']i"},hr=function(e){return e.join("")},yr=function(e){return{type:"STRING",value:e}},xr=/^[^'\\' ']/i,Pr={type:"class",value:"[^'\\\\' ']i",description:"[^'\\\\' ']i"},Ar="'",Er={type:"literal",value:"'",description:'"\'"'},mr=/^[^'\\'']/,br={type:"class",value:"[^'\\\\'']",description:"[^'\\\\'']"},Rr=0,Cr=0,gr=[{line:1,column:1,seenCR:!1}],Sr=0,Dr=[],Tr=0,wr={};if("startRule"in N){if(!(N.startRule in k))throw Error("Can't start parsing from rule \""+N.startRule+'".');_=k[N.startRule]}if(I=_(),I!==O&&Rr===e.length)return I;throw I!==O&&Rr<e.length&&u({type:"end",description:"end of input"}),s(null,Dr,Sr<e.length?e.charAt(Sr):null,Sr<e.length?n(Sr,Sr+1):n(Sr,Sr))}return e(t,Error),{SyntaxError:t,parse:r}}();
