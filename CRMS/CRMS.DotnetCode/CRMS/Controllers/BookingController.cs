using AutoMapper;
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
    public class BookingController : BaseApiController
    {
        private IUow _uow;
        private ILog _log;

        public BookingController(IUow uow, ILog log)
        {
            _uow = uow;
            _log = log;
        }

        public async Task<IHttpActionResult> GetBookings()
        {
            var oBookingList = await this._uow.BookingRepository.Get();
            var result = Mapper.Map<IEnumerable<Booking>, IEnumerable<BookingViewModel>>(oBookingList).ToList();
            return Ok(result.OrderByDescending(d => d.StartDateTs));
        }

        public async Task<IHttpActionResult> GetBookingsByUser(string userId)
        {
            var oBookingList = await this._uow.BookingRepository.Get(d => d.UserId == userId);
            var result = Mapper.Map<IEnumerable<Booking>, IEnumerable<BookingViewModel>>(oBookingList).ToList();
            return Ok(result.OrderByDescending(d => d.StartDateTs));
        }

        public async Task<IHttpActionResult> GetCurrentMonthBookings(string userId = "")
         {
            var oBookingList = await this._uow.BookingRepository.Get(d => (d.CreationTs.Month == DateTime.Now.Month && d.CreationTs.Year == DateTime.Now.Year)
            && string.IsNullOrEmpty(userId) ? true : d.UserId == userId);
            var result = Mapper.Map<IEnumerable<Booking>, IEnumerable<BookingViewModel>>(oBookingList).ToList();
            return Ok(result.OrderByDescending(d=>d.StartDateTs));
        }


        [HttpPost]
        public async Task<IHttpActionResult> Save(Booking booking)
        {
            PopulateMetaData(booking);
            await _uow.BookingRepository.SaveBooking(booking);
            await _uow.SaveAsync();
            return Ok(booking);
        }

        [HttpPut]
        public async Task<IHttpActionResult> CancelBooking(Booking oBooking)
        {
            var bookingDetails = await _uow.BookingRepository.GetByID(oBooking.Id);
            bookingDetails.IsCancelled = true;
            PopulateMetaData(bookingDetails);
            _uow.BookingRepository.Save(bookingDetails);
            await _uow.SaveAsync();
            return Ok();
        }


        [HttpDelete]
        public async Task<IHttpActionResult> Delete(long id)
        {
            await _uow.BookingRepository.Delete(id);
            await _uow.SaveAsync();
            return Ok();
        }
    }
}
