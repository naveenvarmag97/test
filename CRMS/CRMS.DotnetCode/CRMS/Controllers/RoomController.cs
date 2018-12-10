using Data.Entity;
using Data.ViewModel;
using log4net;
using Repository.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;

namespace CRMS.Controllers
{
    //[RoutePrefix("Room")]
    public class RoomController : BaseApiController
    {
        private IUow _uow;
        private ILog _log;

        public RoomController(IUow uow, ILog log)
        {
            _uow = uow;
            _log = log;
        }

        //[HttpGet]
        //[Route("GetRooms")]
        public async Task<IHttpActionResult> GetRooms()
        {
            return Ok(await this._uow.RoomRepository.Get());
        }

        //[HttpGet]
        //[Route("GetActiveRooms")]
        public async Task<IHttpActionResult> GetActiveRooms()
        {
            return Ok(await this._uow.RoomRepository.Get(d=>d.IsActive));
        }

        public async Task<IHttpActionResult> GetRoomsLookup()
        {
            var ActiveRoomList = await this._uow.RoomRepository.Get(d => d.IsActive);
            var RoomLookupList = AutoMapper.Mapper.Map<IEnumerable<ConfreneceRoom>, IEnumerable<LookupViewModel>>(ActiveRoomList);

            return Ok(RoomLookupList.ToList());
        }

        //[HttpPost]
        //public async Task<IHttpActionResult> AddRoom(ConfreneceRoom room)
        //{
        //    PopulateMetaData(room);
        //    _uow.RoomRepository.Insert(room);
        //    await _uow.SaveAsync();
        //    return Ok(room);
        //}

        [HttpPost]
        public async Task<IHttpActionResult> Save(ConfreneceRoom room)
        {
            PopulateMetaData(room);
            _uow.RoomRepository.Save(room);
            await _uow.SaveAsync();
            return Ok(room);
        }


        [HttpDelete]
        public async Task<IHttpActionResult> Delete(long id)
        {
            await _uow.RoomRepository.Delete(id);
            await _uow.SaveAsync();
            return Ok();
        }

    }
}
