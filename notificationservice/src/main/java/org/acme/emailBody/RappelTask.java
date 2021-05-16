package org.acme.emailBody;

public class RappelTask {
    

    public RappelTask() {
    }

    public String body;

    public String bodyEmail(String taskname , Integer projetId ){
        body = "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional //EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"+

        "<html xmlns='http://www.w3.org/1999/xhtml' xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:v='urn:schemas-microsoft-com:vml'>"+
        "<head>"+
        "<!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->"+
        "<meta content='text/html; charset=utf-8' http-equiv='Content-Type'/>"+
        "<meta content='width=device-width' name='viewport'/>"+
        "<!--[if !mso]><!-->"+
        "<meta content='IE=edge' http-equiv='X-UA-Compatible'/>"+
        "<!--<![endif]-->"+
        "<title></title>"+
        "<!--[if !mso]><!-->"+
        "<link href='https://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'/>"+
        "<link href='https://fonts.googleapis.com/css?family=Cabin' rel='stylesheet' type='text/css'/>"+
        "<link href='https://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'/>"+
        "<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'/>"+
        "<link href='https://fonts.googleapis.com/css?family=Merriweather' rel='stylesheet' type='text/css'/>"+
        "<link href='https://fonts.googleapis.com/css?family=Nunito' rel='stylesheet' type='text/css'/>"+
        "<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>"+
        "<!--<![endif]-->"+
        "<style type='text/css'>"+
        "        body {"+
        "            margin: 0;"+
        "            padding: 0;"+
        "        }"+
        ""+
        "        table,"+
        "        td,"+
        "        tr {"+
        "            vertical-align: top;"+
        "            border-collapse: collapse;"+
        "        }"+
        ""+
        "        * {"+
        "            line-height: inherit;"+
        "        }"+
        ""+
        "        a[x-apple-data-detectors=true] {"+
        "            color: inherit !important;"+
        "            text-decoration: none !important;"+
        "        }"+
        "    </style>"+
        "<style id='media-query' type='text/css'>"+
        "        @media (max-width: 700px) {"+
        ""+
        "            .block-grid,"+
        "            .col {"+
        "                min-width: 320px !important;"+
        "                max-width: 100% !important;"+
        "                display: block !important;"+
        "            }"+
        ""+
        "            .block-grid {"+
        "                width: 100% !important;"+
        "            }"+
        ""+
        "            .col {"+
        "                width: 100% !important;"+
        "            }"+
        ""+
        "            .col_cont {"+
        "                margin: 0 auto;"+
        "            }"+
        ""+
        "            img.fullwidth,"+
        "            img.fullwidthOnMobile {"+
        "                max-width: 100% !important;"+
        "            }"+
        ""+
        "            .no-stack .col {"+
        "                min-width: 0 !important;"+
        "                display: table-cell !important;"+
        "            }"+
        ""+
        "            .no-stack.two-up .col {"+
        "                width: 50% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num2 {"+
        "                width: 16.6% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num3 {"+
        "                width: 25% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num4 {"+
        "                width: 33% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num5 {"+
        "                width: 41.6% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num6 {"+
        "                width: 50% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num7 {"+
        "                width: 58.3% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num8 {"+
        "                width: 66.6% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num9 {"+
        "                width: 75% !important;"+
        "            }"+
        ""+
        "            .no-stack .col.num10 {"+
        "                width: 83.3% !important;"+
        "            }"+
        ""+
        "            .video-block {"+
        "                max-width: none !important;"+
        "            }"+
        ""+
        "            .mobile_hide {"+
        "                min-height: 0px;"+
        "                max-height: 0px;"+
        "                max-width: 0px;"+
        "                display: none;"+
        "                overflow: hidden;"+
        "                font-size: 0px;"+
        "            }"+
        ""+
        "            .desktop_hide {"+
        "                display: block !important;"+
        "                max-height: none !important;"+
        "            }"+
        "        }"+
        "    </style>"+
        "<style id='menu-media-query' type='text/css'>"+
        "        @media (max-width: 700px) {"+
        "            .menu-checkbox[type='checkbox']~.menu-links {"+
        "                display: none !important;"+
        "                padding: 5px 0;"+
        "            }"+
        ""+
        "            .menu-checkbox[type='checkbox']~.menu-links span.sep {"+
        "                display: none;"+
        "            }"+
        ""+
        "            .menu-checkbox[type='checkbox']:checked~.menu-links,"+
        "            .menu-checkbox[type='checkbox']~.menu-trigger {"+
        "                display: block !important;"+
        "                max-width: none !important;"+
        "                max-height: none !important;"+
        "                font-size: inherit !important;"+
        "            }"+
        ""+
        "            .menu-checkbox[type='checkbox']~.menu-links>a,"+
        "            .menu-checkbox[type='checkbox']~.menu-links>span.label {"+
        "                display: block !important;"+
        "                text-align: center;"+
        "            }"+
        ""+
        "            .menu-checkbox[type='checkbox']:checked~.menu-trigger .menu-close {"+
        "                display: block !important;"+
        "            }"+
        ""+
        "            .menu-checkbox[type='checkbox']:checked~.menu-trigger .menu-open {"+
        "                display: none !important;"+
        "            }"+
        ""+
        "            #menunej32o~div label {"+
        "                border-radius: 0% !important;"+
        "            }"+
        ""+
        "            #menunej32o:checked~.menu-links {"+
        "                background-color: #000000 !important;"+
        "            }"+
        ""+
        "            #menunej32o:checked~.menu-links a {"+
        "                color: #ffffff !important;"+
        "            }"+
        ""+
        "            #menunej32o:checked~.menu-links span {"+
        "                color: #ffffff !important;"+
        "            }"+
        "        }"+
        "    </style>"+
        "<style id='icon-media-query' type='text/css'>"+
        "        @media (max-width: 700px) {"+
        "            .icons-inner {"+
        "                text-align: center;"+
        "            }"+
        ""+
        "            .icons-inner td {"+
        "                margin: 0 auto;"+
        "            }"+
        "        }"+
        "    </style>"+
        "</head>"+
        "<body class='clean-body' style='margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #d7ebff;'>"+
        "<!--[if IE]><div class='ie-browser'><![endif]-->"+
        "<table bgcolor='#d7ebff' cellpadding='0' cellspacing='0' class='nl-container' role='presentation' style='table-layout: fixed; vertical-align: top; min-width: 320px; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #d7ebff; width: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td style='word-break: break-word; vertical-align: top;' valign='top'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td align='center' style='background-color:#d7ebff'><![endif]-->"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #011776;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#011776;'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:#011776'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:#011776;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:30px; padding-bottom:30px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 0px; padding-left: 0px;'>"+
        "<!--<![endif]-->"+
        "<div align='center' class='img-container center autowidth' style='padding-right: 0px;padding-left: 0px;'>"+
        "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr style='line-height:0px'><td style='padding-right: 0px;padding-left: 0px;' align='center'><![endif]--><img align='center' alt='Yourlogo Light' border='0' class='center autowidth' src='http://localhost:8084/download/Logo-Light.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; width: 100%; max-width: 109px; display: block;' title='Yourlogo Light' width='109'/>"+
        "<!--[if mso]></td></tr></table><![endif]-->"+
        "</div>"+
        "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;' valign='top'>"+
        "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='30' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td height='30' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "</td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #f7fafc;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#f7fafc;background-image:url('images/M-Card.png');background-position:top center;background-repeat:no-repeat'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:#f7fafc'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:#f7fafc;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 20px; padding-left: 20px; padding-top:0px; padding-bottom:0px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 20px; padding-left: 20px;'>"+
        "<!--<![endif]-->"+
        "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 10px; padding-left: 10px; padding-top: 35px; padding-bottom: 0px; font-family: 'Times New Roman', Georgia, serif'><![endif]-->"+
        "<div style='color:#011776;font-family:TimesNewRoman, 'Times New Roman', Times, Beskerville, Georgia, serif;line-height:1.2;padding-top:35px;padding-right:10px;padding-bottom:0px;padding-left:10px;'>"+
        "<div class='txtTinyMce-wrapper' style='line-height: 1.2; font-size: 12px; font-family: TimesNewRoman, 'Times New Roman', Times, Beskerville, Georgia, serif; color: #011776; mso-line-height-alt: 14px;'>"+
        "<p style='margin: 0; text-align: center; line-height: 1.2; word-break: break-word; font-size: 42px; mso-line-height-alt: 50px; margin-top: 0; margin-bottom: 0;'><span style='font-size: 42px;'><strong>Here's what you missed</strong></span></p>"+
        "</div>"+
        "</div>"+
        "<!--[if mso]></td></tr></table><![endif]-->"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #f7fafc;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#f7fafc;background-image:url('images/M-Card.png');background-position:center top;background-repeat:no-repeat'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:#f7fafc'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:#f7fafc;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 20px; padding-left: 20px; padding-top:5px; padding-bottom:0px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 20px; padding-left: 20px;'>"+
        "<!--<![endif]-->"+
        "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Georgia, 'Times New Roman', serif'><![endif]-->"+
        "<div style='color:#011776;font-family:Georgia, Times, 'Times New Roman', serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;'>"+
        "<div class='txtTinyMce-wrapper' style='line-height: 1.2; font-size: 12px; font-family: Georgia, Times, 'Times New Roman', serif; color: #011776; mso-line-height-alt: 14px;'>"+
        "<p style='margin: 0; text-align: center; line-height: 1.2; word-break: break-word; font-size: 46px; mso-line-height-alt: 55px; margin-top: 0; margin-bottom: 0;'><span style='font-size: 46px;'>"+taskname +" is due in a day </span></p>"+
        "</div>"+
        "</div>"+
        "<!--[if mso]></td></tr></table><![endif]-->"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #f7fafc;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#f7fafc;background-image:url('images/M-Card.png');background-position:center top;background-repeat:no-repeat'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:#f7fafc'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:#f7fafc;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 20px; padding-left: 20px; padding-top:0px; padding-bottom:0px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 20px; padding-left: 20px;'>"+
        "<!--<![endif]-->"+
        "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 30px; padding-right: 10px; padding-bottom: 30px; padding-left: 10px;' valign='top'>"+
        "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='1' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 2px solid #A8B1CD; height: 1px; width: 20%;' valign='top' width='20%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td height='1' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "</td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #011776;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#011776;background-image:url('images/B-Card.png');background-position:top center;background-repeat:no-repeat'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:#011776'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:#011776;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;'>"+
        "<!--<![endif]-->"+
        "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;' valign='top'>"+
        "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='30' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td height='30' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "</td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "<div align='center' class='button-container' style='padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;'>"+
        "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;'><tr><td style='padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px' align='center'><v:roundrect xmlns:v='urn:schemas-microsoft-com:vml' xmlns:w='urn:schemas-microsoft-com:office:word' href='' style='height:31.5pt;width:122.25pt;v-text-anchor:middle;' arcsize='10%' stroke='false' fillcolor='#3AAEE0'><w:anchorlock/><v:textbox inset='0,0,0,0'><center style='color:#ffffff; font-family:Arial, sans-serif; font-size:16px'><![endif]-->"+
        "<a href='google.com' style='-webkit-text-size-adjust: none; text-decoration: none; display: inline-block; color: #ffffff; background-color: #3AAEE0; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; width: auto; width: auto; border-top: 1px solid #3AAEE0; border-right: 1px solid #3AAEE0; border-bottom: 1px solid #3AAEE0; border-left: 1px solid #3AAEE0; padding-top: 5px; padding-bottom: 5px; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; text-align: center; mso-border-alt: none; word-break: keep-all;' target='_blank'><span style='padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;letter-spacing:undefined;'><span style='font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;'>Click Here !</span></span></a>"+
        "<!--[if mso]></center></v:textbox></v:roundrect></td></tr></table><![endif]-->"+
        "</div>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: #011776;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:#011776;'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:#011776'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:#011776;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:20px; padding-bottom:5px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:20px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;'>"+
        "<!--<![endif]-->"+
        "<!--[if mso]><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif'><![endif]-->"+
        "<div style='color:#f7fafc;font-family:Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif;line-height:1.2;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;'>"+
        "<div class='txtTinyMce-wrapper' style='line-height: 1.2; font-size: 12px; color: #f7fafc; font-family: Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif; mso-line-height-alt: 14px;'>"+
        "<p style='margin: 0; font-size: 12px; line-height: 1.2; word-break: break-word; text-align: center; mso-line-height-alt: 14px; margin-top: 0; margin-bottom: 0;'><span style='font-size: 12px;'>FOLLOW HIS JOURNEY</span></p>"+
        "</div>"+
        "</div>"+
        "<!--[if mso]></td></tr></table><![endif]-->"+
        "<table cellpadding='0' cellspacing='0' class='social_icons' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td style='word-break: break-word; vertical-align: top; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;' valign='top'>"+
        "<table align='center' cellpadding='0' cellspacing='0' class='social_table' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-tspace: 0; mso-table-rspace: 0; mso-table-bspace: 0; mso-table-lspace: 0;' valign='top'>"+
        "<tbody>"+
        "<tr align='center' style='vertical-align: top; display: inline-block; text-align: center;' valign='top'>"+
        "<td style='word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;' valign='top'><a href='https://www.facebook.com/' target='_blank'><img alt='Facebook' height='32' src='http://localhost:8084/download/facebook2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;' title='facebook' width='32'/></a></td>"+
        "<td style='word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;' valign='top'><a href='https://www.linkedin.com/' target='_blank'><img alt='LinkedIn' height='32' src='http://localhost:8084/download/linkedin2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;' title='LinkedIn' width='32'/></a></td>"+
        "<td style='word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;' valign='top'><a href='https://www.twitter.com/' target='_blank'><img alt='Twitter' height='32' src='http://localhost:8084/download/twitter2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;' title='twitter' width='32'/></a></td>"+
        "<td style='word-break: break-word; vertical-align: top; padding-bottom: 0; padding-right: 2.5px; padding-left: 2.5px;' valign='top'><a href='https://www.instagram.com/' target='_blank'><img alt='Instagram' height='32' src='http://localhost:8084/download/instagram2x.png' style='text-decoration: none; -ms-interpolation-mode: bicubic; height: auto; border: 0; display: block;' title='instagram' width='32'/></a></td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "</td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "<table border='0' cellpadding='0' cellspacing='0' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;' valign='top' width='100%'>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td align='center' style='word-break: break-word; vertical-align: top; padding-top: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px; text-align: center; font-size: 0px;' valign='top'>"+
        "<div class='menu-links'>"+
        "<!--[if mso]>"+
        "<table role='presentation' border='0' cellpadding='0' cellspacing='0' align='center'>"+
        "<tr>"+
        "<td style='padding-top:5px;padding-right:5px;padding-bottom:5px;padding-left:5px'>"+
        "<![endif]--><a href='http://www.example.com' style='padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;display:inline;color:#cccccc;font-family:Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif;font-size:12px;text-decoration:none;letter-spacing:undefined;'>Unsubscribe</a>"+
        "<!--[if mso]></td><td><![endif]--><span class='sep' style='font-size:12px;font-family:Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif;color:#cccccc;'>|</span>"+
        "<!--[if mso]></td><![endif]-->"+
        "<!--[if mso]></td><td style='padding-top:5px;padding-right:5px;padding-bottom:5px;padding-left:5px'><![endif]--><a href='http://www.example.com' style='padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;display:inline;color:#cccccc;font-family:Open Sans, Helvetica Neue, Helvetica, Arial, sans-serif;font-size:12px;text-decoration:none;letter-spacing:undefined;'>Manage Preferences</a>"+
        "<!--[if mso]></td></tr></table><![endif]-->"+
        "</div>"+
        "</td>"+
        "</tr>"+
        "</table>"+
        "<table border='0' cellpadding='0' cellspacing='0' class='divider' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td class='divider_inner' style='word-break: break-word; vertical-align: top; min-width: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; padding-top: 10px; padding-right: 10px; padding-bottom: 10px; padding-left: 10px;' valign='top'>"+
        "<table align='center' border='0' cellpadding='0' cellspacing='0' class='divider_content' height='30' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-top: 0px solid transparent; height: 30px; width: 100%;' valign='top' width='100%'>"+
        "<tbody>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td height='30' style='word-break: break-word; vertical-align: top; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;' valign='top'><span></span></td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "</td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<div style='background-color:transparent;'>"+
        "<div class='block-grid' style='min-width: 320px; max-width: 680px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; Margin: 0 auto; background-color: transparent;'>"+
        "<div style='border-collapse: collapse;display: table;width: 100%;background-color:transparent;'>"+
        "<!--[if (mso)|(IE)]><table width='100%' cellpadding='0' cellspacing='0' border='0' style='background-color:transparent;'><tr><td align='center'><table cellpadding='0' cellspacing='0' border='0' style='width:680px'><tr class='layout-full-width' style='background-color:transparent'><![endif]-->"+
        "<!--[if (mso)|(IE)]><td align='center' width='680' style='background-color:transparent;width:680px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;' valign='top'><table width='100%' cellpadding='0' cellspacing='0' border='0'><tr><td style='padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;'><![endif]-->"+
        "<div class='col num12' style='min-width: 320px; max-width: 680px; display: table-cell; vertical-align: top; width: 680px;'>"+
        "<div class='col_cont' style='width:100% !important;'>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "<div style='border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;'>"+
        "<!--<![endif]-->"+
        "<table cellpadding='0' cellspacing='0' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt;' valign='top' width='100%'>"+
        "<tr style='vertical-align: top;' valign='top'>"+
        "<td align='center' style='word-break: break-word; vertical-align: top; padding-top: 5px; padding-right: 0px; padding-bottom: 5px; padding-left: 0px; text-align: center;' valign='top'>"+
        "<!--[if vml]><table align='left' cellpadding='0' cellspacing='0' role='presentation' style='display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;'><![endif]-->"+
        "<!--[if !vml]><!-->"+
        "<table cellpadding='0' cellspacing='0' class='icons-inner' role='presentation' style='table-layout: fixed; vertical-align: top; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;' valign='top'>"+
        "<!--<![endif]-->"+
        "</table>"+
        "</td>"+
        "</tr>"+
        "</table>"+
        "<!--[if (!mso)&(!IE)]><!-->"+
        "</div>"+
        "<!--<![endif]-->"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "<!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->"+
        "</div>"+
        "</div>"+
        "</div>"+
        "<!--[if (mso)|(IE)]></td></tr></table><![endif]-->"+
        "</td>"+
        "</tr>"+
        "</tbody>"+
        "</table>"+
        "<!--[if (IE)]></div><![endif]-->"+
        "</body>"+
        "</html>";
        return body;
    }
}