/**
 * 
 */

  function disable(id)
            {
                var status =  document.getElementById(id).style.visibility;
                if(status=='hidden')
                    {
                        document.getElementById(id).style.visibility='visible';
                    }
                else
                    {
                        document.getElementById(id).style.visibility='hidden';
                    }
            }
            
	function showModal(parameter)
		{
	        document.getElementById(parameter).style.visibility='visible';
	        document.getElementById("body").style.filter='blur(10px)';
	        document.getElementById("body").style.height = '100%';
	        document.getElementById("body").style.overflow= 'hidden';
		}
		function hideModal(parameter)
		{
	        document.getElementById(parameter).style.visibility='hidden';
	        document.getElementById("body").style.filter='none';
	        document.getElementById("body").style.overflow= 'auto';
		}