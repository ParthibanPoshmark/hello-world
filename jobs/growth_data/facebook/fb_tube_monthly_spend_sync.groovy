freeStyleJob('gdf-facebook/gd-facebook-fb_tube_monthly_spend-sync') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Recalculates monthly spend for fb_tube acq_channel "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_acquisition_spend "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	kamal@poshmark.com, parthiban@poshmark.com "+
      "</td>"+
   	"</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Repo  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": etl-configs "+
      "</td>"+
    "</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": dw_acquisition_spend_fb_tube_fee.sql "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+

  "</table>"+
"</html>")

  weight(1)
  
  label('redshift')

  disabled(true)

  wrappers{
    timeout{
      absolute('7')
    }
  }

  steps{
    downstreamParameterized{
      trigger('load_to_redshift_dw_acquisition_spend'){
        parameters{
          predefinedProp('sql_file','/goshposh/etl-configs/dw_acquisition_spend_fb_tube_fee.sql')
        }
      }
    }
  }

}