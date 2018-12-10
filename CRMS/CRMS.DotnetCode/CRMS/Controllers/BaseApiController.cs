using Data.Entity;
using Data.Enum;
using Microsoft.AspNet.Identity.Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Claims;
using System.Threading;
using System.Web;
using System.Web.Http;

namespace CRMS.Controllers
{
    public class BaseApiController : ApiController
    {
        protected void PopulateMetaData(BaseEntity entity)
        {
            if (entity.Id == 0)
            {
                //New Entity
                entity.CreationTs = DateTime.Now;
                entity.CreatedBy = LoggedInUserName;
            }
            else
            {
                entity.ModifiedTs = DateTime.Now;
                entity.ModifiedBy = LoggedInUserName;
            }

            entity.StatusType = StatusType.Enabled;
        }

        //protected User Currentuser
        //{
        //    get
        //    {
        //        var CurrentIdentityClaims = ((ClaimsIdentity)HttpContext.Current.GetOwinContext().Request.User.Identity).Claims.ToList();


        //        return HttpContext.Current.GetOwinContext().GetUserManager<User>();
        //    }
        //}

        protected string LoggedInUserName
        {
            get
            {
                return HttpContext.Current.User.Identity.Name;
            }
        }
    }
}
